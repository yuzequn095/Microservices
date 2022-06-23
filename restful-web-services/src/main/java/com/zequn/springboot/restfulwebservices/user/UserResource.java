package com.zequn.springboot.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {
    @Autowired
    private UserDaoService service;

    // retrieveAllUsers
    @GetMapping(path = "/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }

    // retrieveUser(int id)
    @GetMapping(path = "/users/{id}")
    public User retrieveUser(@PathVariable int id){
        User user = service.findOne(id);
        if(user == null){
            throw new UserNotFoundException("id-" + id + " could not be found.");
        }

        return user;
    }

    // delete user
    @DeleteMapping("/users/{id}")
    public User deleteUser(@PathVariable int id){
        User user = service.deleteById(id);

        if(user == null){
            throw new UserNotFoundException("id-" + id + " could not be found.");
        }

        return user;
    }

    // create user
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user){
        User savedUser = service.save(user);

        // get the current request url with id
        URI target = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(target).build();
    }

}
