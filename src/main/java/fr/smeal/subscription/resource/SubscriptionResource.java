package fr.smeal.subscription.resource;

import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.model.Plan;
import com.stripe.model.Product;
import com.stripe.model.Subscription;
import fr.smeal.subscription.model.CreateSubscriptionForm;
import fr.smeal.subscription.model.KeyValue;
import fr.smeal.subscription.model.User;
import fr.smeal.subscription.service.SubscriptionService;
import fr.smeal.subscription.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/subscription")
@CrossOrigin(origins = "*")
public class SubscriptionResource {

    @Autowired
    private SubscriptionService subService;

    @PostMapping(value = "/create")
    @ResponseBody
    public String craeteSubscription(@RequestBody List<KeyValue> form) {
        Map<String, String> map = new HashMap<>();
        for (KeyValue keyValue : form) {
            map.put(keyValue.getName(), keyValue.getValue());
        }

        System.out.println(form.get(0).getValue());
        try {
            Customer customer = subService.createCustomer(map);
            Product prod = subService.createProduct(map);
            Plan plan = subService.createPlan(prod, map);
            Subscription subscription = subService.createSubscription(customer, plan, map);
            System.out.println("Subscription created: " + subscription.getId());
        } catch (StripeException e) {
            e.printStackTrace();
        }

        return "ok";
    }
//
//    @RequestMapping(value = { "/api/pojo/edit" }, method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
//    @ResponseBody
//    public Boolean editWinner( @RequestBody Pojo pojo) {
//    }
}