package com.zequn.microservices.jpaintro.service;

import com.zequn.microservices.jpaintro.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
