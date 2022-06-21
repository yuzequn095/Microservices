package com.zequn.microservices.jpaintro.service;

import com.zequn.microservices.jpaintro.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserDAOServices {

    @PersistenceContext
    private EntityManager entityManager;

    public long insert(User user){
        // Open Transaction
        entityManager.persist(user);
        // Close Transaction
        return user.getId();
    }
}
