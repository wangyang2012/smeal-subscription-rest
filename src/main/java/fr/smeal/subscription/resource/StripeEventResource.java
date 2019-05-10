package fr.smeal.subscription.resource;

import fr.smeal.subscription.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stripe-events")
@CrossOrigin(origins = "*")
public class StripeEventResource {

    @Autowired
    private SubscriptionService subService;


    @PostMapping(value = "/")
    public ResponseEntity craeteSubscription(@RequestBody String request) {
        System.out.println(request);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}