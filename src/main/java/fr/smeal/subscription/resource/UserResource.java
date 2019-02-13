package fr.smeal.subscription.resource;

import fr.smeal.subscription.model.User;
import fr.smeal.subscription.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping(value="/")
    public Iterable<User> getAll() {
        return userService.findAll();
    }
}
