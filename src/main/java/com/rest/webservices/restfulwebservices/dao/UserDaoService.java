package com.rest.webservices.restfulwebservices.dao;

import com.rest.webservices.restfulwebservices.bean.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {

    static List<User> users = new ArrayList<>();

    static {
        users.add(new User(12,"Jack", new Date()));
        users.add(new User(15,"Marbolo", new Date()));
        users.add(new User(17,"Harry", new Date()));
    }

    public List<User> findAll() {
        return users;
    }

    public User findUser(Integer id) {
        for(User user: users) {
            if(user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User deleteById(Integer id){
        Iterator<User> itr = users.iterator();
        while(itr.hasNext()){
            User user = itr.next();
            if(user.getId() == id){
                itr.remove();
                return user;
            }
        }
        return null;
    }
}