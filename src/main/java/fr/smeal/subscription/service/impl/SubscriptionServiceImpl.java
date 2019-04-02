package fr.smeal.subscription.service.impl;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.model.Plan;
import com.stripe.model.Product;
import com.stripe.model.Subscription;
import fr.smeal.subscription.service.SubscriptionService;
import fr.smeal.subscription.util.ParameterUtil;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

@Service("subscriptionService")
@Transactional
public class SubscriptionServiceImpl implements SubscriptionService {
    @Override
    public Customer createCustomer(Map<String, String> parameters) throws StripeException {
        Stripe.apiKey = ParameterUtil.stripApiKey;

        Map<String, Object> customerParams = new HashMap<String, Object>();
        customerParams.put("email", parameters.get("email"));
        customerParams.put("description", parameters.get("username"));
        customerParams.put("source", parameters.get("stripeToken"));

        return Customer.create(customerParams);
    }

    @Override
    public Product createProduct(Map<String, String> parameters) throws StripeException {
        // Set your secret key: remember to change this to your live secret key in production
        // See your keys here: https://dashboard.stripe.com/account/apikeys
        Stripe.apiKey = ParameterUtil.stripApiKey;

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", parameters.get("product-name"));
        params.put("type", "service");

        return Product.create(params);
    }

    @Override
    public Plan createPlan(Product product, Map<String, String> parameters) throws StripeException {
        Stripe.apiKey = ParameterUtil.stripApiKey;

        Map<String, Object> params = new HashMap<>();
        params.put("currency", "eur");
        params.put("interval", "month");
        params.put("product", product.getId());
        params.put("nickname", "Prod Plan");
        params.put("amount", parameters.get("product-price").replaceAll(".", ""));
        return Plan.create(params);
    }

    @Override
    public Subscription createSubscription(Customer customer, Plan plan, Map<String, String> parameters) throws StripeException {
        Stripe.apiKey = ParameterUtil.stripApiKey;

        Map<String, Object> item = new HashMap<>();
        item.put("plan", plan.getId());
        Map<String, Object> items = new HashMap<>();
        items.put("0", item);
        Map<String, Object> params = new HashMap<>();
        params.put("customer", customer.getId());
        params.put("items", items);
        return Subscription.create(params);
    }
}
