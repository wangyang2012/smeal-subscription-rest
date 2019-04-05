package fr.smeal.subscription.dao;

import fr.smeal.subscription.model.CartCoupon;
import fr.smeal.subscription.model.CartCouponPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartCouponRepository extends JpaRepository<CartCoupon, CartCouponPk> {
}
