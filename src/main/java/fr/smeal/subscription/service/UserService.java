package fr.smeal.subscription.service;

import fr.smeal.subscription.model.User;

public interface UserService {
    Iterable<User> findAll();
}
