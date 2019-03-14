package fr.smeal.subscription.service.impl;

import fr.smeal.subscription.model.Customer;
import fr.smeal.subscription.service.CustomerService;
import fr.smeal.subscription.util.NetworkUtil;
import fr.smeal.subscription.util.XmlUtil;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Override
    public Customer getCustomer(Integer customerId) {

        String url = "https://www.smeal.fr/api/customers/" + customerId + "?ws_key=9IY4WY4Z4W12C5B4K38CC2X7G8NGGEK2";
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
            return customer;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
