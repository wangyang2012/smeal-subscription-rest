package fr.smeal.subscription.resource;

import fr.smeal.subscription.service.SubscriptionService;
import fr.smeal.subscription.util.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/stripe-events")
@CrossOrigin(origins = "*")
public class StripeEventResource {

    @Autowired
    private SubscriptionService subService;


    @PostMapping(value = "/")
    public ResponseEntity craeteSubscription(@RequestBody Map<Object, Object> request) {

        System.out.println("======================= " + request.get("type") + " =======================");
        StringBuilder sb = new StringBuilder();
        MapUtil.displayMap(request, sb, 0);
        System.out.println(sb.toString());


        Map<String, Object> mapObject = (Map<String, Object>) request.get("object");


        if ("invoice.payment_succeeded".equals(mapObject.get("type"))) {
            // paiement réussi
            // TODO: create order in Smeal
            Integer cartId = MapUtil.getCartIdFromMap(request);
            System.out.println("cartId: " + cartId);
//             createCommandInSmeal();
        } else if ("customer.source.expiring".equals(mapObject.get("type"))) {
            // TODO: inform client when his card is expiring
            // creditCardExpiring();
        }

        return ResponseEntity.ok(HttpStatus.OK);
    }
}

/*
paiement réussi request:

{
  "created": 1326853478,
  "livemode": false,
  "id": "evt_00000000000000",
  "type": "invoice.payment_succeeded",
  "object": "event",
  "request": null,
  "pending_webhooks": 1,
  "api_version": "2018-11-08",
  "data": {
    "object": {
      "id": "in_00000000000000",
      "object": "invoice",
      "account_country": "FR",
      "account_name": null,
      "amount_due": 490,
      "amount_paid": 490,
      "amount_remaining": 0,
      "application_fee": null,
      "attempt_count": 1,
      "attempted": true,
      "auto_advance": false,
      "billing": "charge_automatically",
      "billing_reason": "subscription_cycle",
      "charge": "_00000000000000",
      "collection_method": "charge_automatically",
      "created": 1559870505,
      "currency": "eur",
      "custom_fields": null,
      "customer": "cus_00000000000000",
      "customer_address": null,
      "customer_email": "test@test.com",
      "customer_name": null,
      "customer_phone": null,
      "customer_shipping": null,
      "customer_tax_exempt": "none",
      "customer_tax_ids": [
      ],
      "date": 1559870505,
      "default_payment_method": null,
      "default_source": null,
      "default_tax_rates": [
      ],
      "description": null,
      "discount": null,
      "due_date": null,
      "ending_balance": 0,
      "finalized_at": 1559874137,
      "footer": null,
      "hosted_invoice_url": "https://pay.stripe.com/invoice/invst_1Gfs7LPAkC9iJzIjZCPHud82mK",
      "invoice_pdf": "https://pay.stripe.com/invoice/invst_1Gfs7LPAkC9iJzIjZCPHud82mK/pdf",
      "lines": {
        "data": [
          {
            "id": "sli_00000000000000",
            "object": "line_item",
            "amount": 490,
            "currency": "eur",
            "description": "1 × chocolat (at €4.90 / month)",
            "discountable": true,
            "livemode": false,
            "metadata": {
            },
            "period": {
              "end": 1565140905,
              "start": 1562462505
            },
            "plan": {
              "id": "plan_00000000000000",
              "object": "plan",
              "active": true,
              "aggregate_usage": null,
              "amount": 490,
              "billing_scheme": "per_unit",
              "created": 1549497645,
              "currency": "eur",
              "interval": "month",
              "interval_count": 1,
              "livemode": false,
              "metadata": {
              },
              "nickname": "Chocolat Plan",
              "product": "prod_00000000000000",
              "tiers": null,
              "tiers_mode": null,
              "transform_usage": null,
              "trial_period_days": null,
              "usage_type": "licensed"
            },
            "proration": false,
            "quantity": 1,
            "subscription": "sub_00000000000000",
            "subscription_item": "si_00000000000000",
            "tax_amounts": [
            ],
            "tax_rates": [
            ],
            "type": "subscription"
          }
        ],
        "has_more": false,
        "object": "list",
        "url": "/v1/invoices/in_1EiWmEGyqaBxLPVwnaKweXt6/lines"
      },
      "livemode": false,
      "metadata": {
      },
      "next_payment_attempt": null,
      "number": "69ED472-0009",
      "paid": true,
      "payment_intent": "pi_00000000000000",
      "period_end": 1559870505,
      "period_start": 1557192105,
      "post_payment_credit_notes_amount": 0,
      "pre_payment_credit_notes_amount": 0,
      "receipt_number": null,
      "starting_balance": 0,
      "statement_descriptor": null,
      "status": "paid",
      "status_transitions": {
        "finalized_at": 1559874137,
        "marked_uncollectible_at": null,
        "paid_at": 1559874139,
        "voided_at": null
      },
      "subscription": "sub_00000000000000",
      "subtotal": 490,
      "tax": null,
      "tax_percent": null,
      "total": 490,
      "total_tax_amounts": [
      ],
      "webhooks_delivered_at": 1559870515,
      "closed": true
    }
  }
}
 */




/*
Credit card expiring

{
  "created": 1326853478,
  "livemode": false,
  "id": "evt_00000000000000",
  "type": "customer.source.expiring",
  "object": "event",
  "request": null,
  "pending_webhooks": 1,
  "api_version": "2018-11-08",
  "data": {
    "object": {
      "id": "src_00000000000000",
      "object": "source",
      "ach_credit_transfer": {
        "account_number": "test_52796e3294dc",
        "routing_number": "110000000",
        "fingerprint": "ecpwEzmBOSMOqQTL",
        "bank_name": "TEST BANK",
        "swift_code": "TSTEZ122"
      },
      "amount": null,
      "client_secret": "src_client_secret_FENpfb8QuSP5ICJbmBc2CfvY",
      "created": 1560202208,
      "currency": "eur",
      "flow": "receiver",
      "livemode": false,
      "metadata": {
      },
      "owner": {
        "address": null,
        "email": "jenny.rosen@example.com",
        "name": null,
        "phone": null,
        "verified_address": null,
        "verified_email": null,
        "verified_name": null,
        "verified_phone": null
      },
      "receiver": {
        "address": "121042882-38381234567890123",
        "amount_charged": 0,
        "amount_received": 0,
        "amount_returned": 0,
        "refund_attributes_method": "email",
        "refund_attributes_status": "missing"
      },
      "statement_descriptor": null,
      "status": "pending",
      "type": "ach_credit_transfer",
      "usage": "reusable"
    }
  }
}
 */