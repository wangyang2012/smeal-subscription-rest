package fr.smeal.subscription.dao;

import fr.smeal.subscription.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
