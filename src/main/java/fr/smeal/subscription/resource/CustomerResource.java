package fr.smeal.subscription.resource;

import fr.smeal.subscription.model.Customer;
import fr.smeal.subscription.model.KeyValue;
import fr.smeal.subscription.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "*")
public class CustomerResource {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value="/{customerId}")
    public Customer getCustomer(@PathVariable Integer customerId) {
        Customer customer = customerService.getCustomer(customerId);
        return customer;
//        KeyValue keyValue = new KeyValue();
//        keyValue.setName("response");
//        keyValue.setValue(customer);
//        return keyValue;
    }
}
