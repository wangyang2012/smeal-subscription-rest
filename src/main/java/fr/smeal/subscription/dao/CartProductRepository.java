package fr.smeal.subscription.dao;

import fr.smeal.subscription.entity.CartProductEntity;
import fr.smeal.subscription.entity.CartProductPk;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartProductRepository extends JpaRepository<CartProductEntity, CartProductPk> {
    List<CartProductEntity> findById_IdCart(Integer idCart);
}
