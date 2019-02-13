package fr.smeal.subscription.service.impl;

import fr.smeal.subscription.dao.UserRepository;
import fr.smeal.subscription.model.User;
import fr.smeal.subscription.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public Iterable<User> findAll() {
        return userRepo.findAll();
    }
}
