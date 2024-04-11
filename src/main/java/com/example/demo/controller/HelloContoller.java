package com.example.demo.controller;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class HelloContoller {

    private static final Logger log = Logger.getLogger(HelloContoller.class.getName());

    @Autowired
    ProducerTemplate producerTemplate;

    @GetMapping("/hello")
    public void sayHello(){
        log.info("hello from endpoint /hello");
        producerTemplate.sendBody("direct:hello", "Calling via Spring Boot Rest Controller");
    }
}
