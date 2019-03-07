package fr.smeal.subscription.service.impl;

import fr.smeal.subscription.model.Customer;
import fr.smeal.subscription.model.Language;
import fr.smeal.subscription.service.CustomerService;
import fr.smeal.subscription.util.NetworkUtil;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Override
    public String getCustomer(Integer customerId) {
//        test();

        String url = "https://www.smeal.fr/api/customers/" + customerId + "?ws_key=9IY4WY4Z4W12C5B4K38CC2X7G8NGGEK2";
        try {
            String customerStr = NetworkUtil.sendGet(url);

            customerStr = customerStr.substring(customerStr.indexOf("<customer>"));
            customerStr = customerStr.replaceAll("</prestashop>", "");
            customerStr = customerStr.replaceAll("<!\\[CDATA\\[", "");
            customerStr = customerStr.replaceAll("]]>", "");

//            JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
//            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//            StringReader reader = new StringReader(customerStr);
//            Customer customer = (Customer) jaxbUnmarshaller.unmarshal(reader);
//            System.out.println(customer.getFirstName());
            return customerStr;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private void test() {
        String url = "https://www.smeal.fr/api/languages/1?ws_key=9IY4WY4Z4W12C5B4K38CC2X7G8NGGEK2";
        try {
            String customerStr = NetworkUtil.sendGet(url);

            customerStr = customerStr.substring(customerStr.indexOf("<language>"));
            customerStr = customerStr.replaceAll("</prestashop>", "");
            customerStr = customerStr.replaceAll("<!\\[CDATA\\[", "");
            customerStr = customerStr.replaceAll("]]>", "");

            JAXBContext jaxbContext = JAXBContext.newInstance(Language.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            StringReader reader = new StringReader(customerStr);
            Language language = (Language) jaxbUnmarshaller.unmarshal(reader);
            System.out.println(language.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
