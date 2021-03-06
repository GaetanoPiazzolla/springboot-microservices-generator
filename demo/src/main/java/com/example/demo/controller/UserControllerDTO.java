package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.controller.dto.UserDTO;
import com.example.demo.service.UserService;
import com.example.demo.service.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
* Generated by Springboot-3layer-Generator at Jan 6, 2021, 8:30:41 PM
*/
@RestController
@RequestMapping("/user-dto/")
public class UserControllerDTO implements CrudController<UserDTO,java.lang.Integer>{

    @Autowired
    private UserService service;

    @Autowired
    private UserMapper mapper;

    @Override
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO dto) {
       User entity = mapper.toEntity(dto);
       entity = service.create(entity);
       return ResponseEntity.ok(mapper.toDto(entity));
    }

    @Override
    public ResponseEntity<UserDTO> update(@RequestBody UserDTO dto) {
      User entity = mapper.toEntity(dto);
       entity = service.update(entity);
       return ResponseEntity.ok(mapper.toDto(entity));
    }

    @Override
    public ResponseEntity<Page<UserDTO>> read(
            @RequestBody UserDTO dto,
            @RequestParam("page") Integer page,
            @RequestParam("size") Integer size) {
        Pageable pageable = PageRequest.of(page,size);
        User entity = mapper.toEntity(dto);
        Page<UserDTO> pages = service.read(entity, pageable).map(mapper::toDto);
        return ResponseEntity.ok(pages);
    }

    @Override
    public ResponseEntity<UserDTO> readOne(@PathVariable("id") java.lang.Integer primaryKey) {
         User entity = service.readOne(primaryKey);
         return ResponseEntity.ok(mapper.toDto(entity));
    }

    @Override
    public void delete(java.lang.Integer primaryKey) {
        service.delete(primaryKey);
    }
}