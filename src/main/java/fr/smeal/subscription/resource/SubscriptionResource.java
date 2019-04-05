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
    public KeyValue craeteSubscription(@RequestBody Map<String, String> form) {
        Map<String, String> map = new HashMap<>();
        map.put("email", form.get("email"));
        map.put("username", form.get("userName"));
        map.put("stripeToken", form.get("stripeToken"));
        map.put("product-name", form.get("productName"));
        map.put("product-price", form.get("productPrice"));

        try {
            Customer customer = subService.createCustomer(map);
            Product prod = subService.createProduct(map);
            Plan plan = subService.createPlan(prod, map);
            Subscription subscription = subService.createSubscription(customer, plan, map);
            System.out.println("Subscription created: " + subscription.getId());
        } catch (StripeException e) {
            e.printStackTrace();
        }

        KeyValue keyValue = new KeyValue();
        keyValue.setName("response");
        keyValue.setValue("ok");
        return keyValue;
    }
}