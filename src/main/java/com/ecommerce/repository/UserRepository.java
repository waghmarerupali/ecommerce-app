package com.ecommerce.repository;

import com.ecommerce.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

        //here we have written custom find methods


       Optional<User> findByEmail(String email);
        Optional<User> findByEmailAndPassword(String email,String password);
        List<User> findByUserNameContaining(String keyword);

        }
