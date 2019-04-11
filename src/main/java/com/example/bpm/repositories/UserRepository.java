package com.example.bpm.repositories;

import com.example.bpm.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findByName(String name);
    List<User> findByEmail(String email);
}
