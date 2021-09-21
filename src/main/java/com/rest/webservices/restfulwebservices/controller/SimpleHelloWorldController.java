package com.rest.webservices.restfulwebservices.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleHelloWorldController {

    @GetMapping(path = "/hello-world")
    public String display(){
        return "Hello world!";
    }
}
