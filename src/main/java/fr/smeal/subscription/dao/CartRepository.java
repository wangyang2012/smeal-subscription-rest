package fr.smeal.subscription.dao;

import fr.smeal.subscription.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartEntity, Integer> {
    CartEntity getById(Integer id);
}
