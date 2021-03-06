package fr.smeal.subscription.resource;

import fr.smeal.subscription.model.Customer;
import fr.smeal.subscription.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "*")
public class CustomerResource {

    @Autowired
    private CustomerService customerService;

    @PutMapping(value="/{customerId}/cart/{cartId}")
    public Customer getCustomer(@PathVariable Integer customerId, @PathVariable Integer cartId, @RequestBody String customerToken) {
        Customer customer = customerService.getCustomer(customerId, customerToken, cartId);
        return customer;
    }
}
