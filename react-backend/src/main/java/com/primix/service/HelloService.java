package com.primix.service;

import com.primix.model.exam.Hello;
import com.primix.respositories.HelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloService {
    @Autowired
    HelloRepository helloRepository;

    @GetMapping("/api/hello")
    public Iterable<Hello> findAllHellos(){
        return helloRepository.findAll();
    }
}