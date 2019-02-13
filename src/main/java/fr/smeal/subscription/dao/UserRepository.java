package fr.smeal.subscription.dao;

import fr.smeal.subscription.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
