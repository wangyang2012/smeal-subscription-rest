package fr.smeal.subscription.service;

import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.model.Plan;
import com.stripe.model.Product;
import com.stripe.model.Subscription;
import fr.smeal.subscription.model.User;

import java.util.Map;

public interface SubscriptionService {
    Customer createCustomer(Map<String, String> parameters) throws StripeException;
    Product createProduct(Map<String, String> parameters) throws StripeException;
    Plan createPlan(Product product, Map<String, String> parameters) throws StripeException;
    Subscription createSubscription(Customer customer, Plan plan, Map<String, String> parameters) throws StripeException;
}
