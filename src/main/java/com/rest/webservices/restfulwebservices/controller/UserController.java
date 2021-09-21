package com.rest.webservices.restfulwebservices.controller;

import com.rest.webservices.restfulwebservices.bean.User;
import com.rest.webservices.restfulwebservices.dao.UserDaoService;
import com.rest.webservices.restfulwebservices.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDaoService userDaoService;

    @GetMapping(path="/users")
    public List<User> retrieveAllUsers(){
        return userDaoService.findAll();
    }

    @GetMapping(path="/users/{id}")
    public ResponseEntity<User> retrieveAllUsers(@PathVariable Integer id){

        User user = userDaoService.findUser(id);
        if(null == user){
            //return new ResponseEntity(user, HttpStatus.NOT_FOUND);
            throw new UserNotFoundException(id+"");
        }
        else
            return new ResponseEntity(user, HttpStatus.OK);
    }

    @DeleteMapping(path="/users/{id}")
    public ResponseEntity<Object> findUser(@PathVariable Integer id){
        User user = userDaoService.deleteById(id);
        if(user == null)
            throw new UserNotFoundException(id+"");
        else
            return ResponseEntity.noContent().build();
    }
}

