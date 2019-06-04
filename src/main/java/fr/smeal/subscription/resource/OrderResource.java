package fr.smeal.subscription.resource;

import fr.smeal.subscription.model.Order;
import fr.smeal.subscription.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "*")
public class OrderResource {

    @Autowired
    private OrderService orderService;

    @GetMapping(value="/create")
    public Order createOrder() {
        Order order = orderService.createOrder();
        return order;
    }
}
