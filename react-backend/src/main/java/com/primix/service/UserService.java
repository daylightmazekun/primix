package com.primix.service;

import javax.servlet.http.HttpSession;
import com.primix.respositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserService{

    @Autowired
    UserRepository userRepository;
    @Autowired
    private HttpSession session;

    @DeleteMapping("/api/user/{userId}")
    public void deleteUser(@PathVariable("userId") int id){
        userRepository.deleteById(id);
    }
    // TODO

}