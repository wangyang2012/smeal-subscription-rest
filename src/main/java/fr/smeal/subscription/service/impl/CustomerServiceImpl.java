package fr.smeal.subscription.service.impl;

import fr.smeal.subscription.model.Customer;
import fr.smeal.subscription.service.CustomerService;
import fr.smeal.subscription.util.NetworkUtil;
import fr.smeal.subscription.util.ParameterUtil;
import fr.smeal.subscription.util.XmlUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Override
    public Customer getCustomer(Integer customerId, String customerToken) {
        if (customerId == null || StringUtils.isEmpty(customerToken)) {
            return null;
        }

        String url = ParameterUtil.getSmealApiUrl("/customers/" + customerId);
        try {
            String customerStr = NetworkUtil.sendGet(url);

            customerStr = customerStr.substring(customerStr.indexOf("<customer>"));
            customerStr = customerStr.replaceAll("</prestashop>", "");
            customerStr = customerStr.replaceAll("<!\\[CDATA\\[", "");
            customerStr = customerStr.replaceAll("]]>", "");

            Customer customer = new Customer();
            customer.setId(Integer.valueOf(XmlUtil.getValue(customerStr, "id")));
            customer.setFirstName(XmlUtil.getValue(customerStr, "firstname"));
            customer.setLastName(XmlUtil.getValue(customerStr, "lastname"));
            customer.setEmail(XmlUtil.getValue(customerStr, "email"));
            customer.setPassword(XmlUtil.getValue(customerStr, "passwd"));
            // TODO: get city, address, zipCode
            String secureKey = XmlUtil.getValue(customerStr, "secure_key");
            customer.setToken(secureKey);
            if (!customerToken.equals(secureKey)) {
                return null;
            }

            return customer;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
