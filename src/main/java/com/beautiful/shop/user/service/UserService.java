package com.beautiful.shop.user.service;

import com.beautiful.shop.user.entity.User;
import com.beautiful.shop.user.entity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Repository
 * @Service
 * -> <p>
 * @Autowired
 * private UserService userService;
 * </p>
 *
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void saveUser(User user){
        userRepository.save(user);
    }
}
