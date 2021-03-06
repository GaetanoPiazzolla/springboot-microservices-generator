package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
* Generated by Springboot-3layer-Generator at Jan 6, 2021, 8:30:41 PM
*/
@Service
public class UserServiceBean implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User create(User entity) {
        return repository.save(entity);
    }

    @Override
    public User update(User entity) {
        return repository.save(entity);
    }

    @Override
    public Page<User> read(User entity, Pageable pageable) {
        Example<User> example = Example.of(entity);
        return repository.findAll(example,pageable);
    }

    @Override
    public User readOne(java.lang.Integer primaryKey) {
        return repository.getOne(primaryKey);
    }

    @Override
    public void delete(java.lang.Integer primaryKey) {
        repository.deleteById(primaryKey);
    }
}