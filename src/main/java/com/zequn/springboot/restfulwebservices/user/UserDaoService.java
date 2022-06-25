package com.zequn.springboot.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


// @Component is an annotation that allows Spring to automatically detect our custom beans.
@Component // talking to the database
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Jason", new Date()));
        users.add(new User(2, "Iris", new Date()));
        users.add(new User(3, "Yuric", new Date()));
    }

    private static int usersCount = 3;

    // return the whole list of users
    public List<User> findAll(){
        return users;
    }

    // save new user to db
    public User save(User user){

        if(user.getId() == null){
            user.setId(++usersCount);
        }

        users.add(user);

        return user;
    }

    // find the specific user
    public User findOne(int id){
        for(User user : users){
            if(user.getId() == id){
                return user;
            }
        }

        return null;
    }

    // delete the specific user
    public User deleteById(int id) {
        Iterator<User> iterator = users.iterator();
        while(iterator.hasNext()){
            User user = iterator.next();
            if(user.getId() == id){
                iterator.remove();
                return user;
            }
        }
        return null;
    }
}
