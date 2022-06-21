package com.zequn.microservices.jpaintro;

import com.zequn.microservices.jpaintro.entity.User;
import com.zequn.microservices.jpaintro.service.UserDAOServices;
import com.zequn.microservices.jpaintro.service.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(UserDaoServiceCommandLineRunner.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user = new User("Jack", "Admin");
        userRepository.save(user);
        log.info("New User is created: " + user);
    }
}
