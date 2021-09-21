package com.rest.webservices.restfulwebservices.controller;

import com.rest.webservices.restfulwebservices.bean.HelloWorldBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class SimpleHelloWorldController {

    @GetMapping(path = "/hello-world")
    public String display(){
        return "Hello world!";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean getBean(){
        return new HelloWorldBean("Hello world Bean!");
    }

    @GetMapping(path = "/hello-world-bean/{name}")
    public HelloWorldBean getBeanWithParam(@PathVariable String name){
        return new HelloWorldBean("Hello world "+name);
    }
}
