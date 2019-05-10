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
        /*
        {
  "id": "evt_1EYNjuGyqaBxLPVwxewqV3g5",
  "object": "event",
  "api_version": "2018-11-08",
  "created": 1557452494,
  "data": {
    "object": {
      "id": "cus_F2SfrmQL1iFRef",
      "object": "customer",
      "account_balance": 0,
      "address": null,
      "created": 1557452494,
      "currency": null,
      "default_source": null,
      "delinquent": false,
      "description": "sqdfmlkqsfez",
      "discount": null,
      "email": "test3@test.com",
      "invoice_prefix": "B71592F9",
      "invoice_settings": {
        "custom_fields": null,
        "default_payment_method": null,
        "footer": null
      },
      "livemode": false,
      "metadata": {
      },
      "name": "test3",
      "phone": null,
      "preferred_locales": [

      ],
      "shipping": null,
      "sources": {
        "object": "list",
        "data": [

        ],
        "has_more": false,
        "total_count": 0,
        "url": "/v1/customers/cus_F2SfrmQL1iFRef/sources"
      },
      "subscriptions": {
        "object": "list",
        "data": [

        ],
        "has_more": false,
        "total_count": 0,
        "url": "/v1/customers/cus_F2SfrmQL1iFRef/subscriptions"
      },
      "tax_exempt": "none",
      "tax_ids": {
        "object": "list",
        "data": [

        ],
        "has_more": false,
        "total_count": 0,
        "url": "/v1/customers/cus_F2SfrmQL1iFRef/tax_ids"
      },
      "tax_info": null,
      "tax_info_verification": null
    }
  },
  "livemode": false,
  "pending_webhooks": 1,
  "request": {
    "id": "req_6Im8clnvY8CM0c",
    "idempotency_key": null
  },
  "type": "customer.created"
}

         */
        return ResponseEntity.ok(HttpStatus.OK);
    }
}