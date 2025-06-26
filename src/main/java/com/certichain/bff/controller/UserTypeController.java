package com.certichain.bff.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.certichain.bff.client.UserTypeClient;
import com.certichain.bff.model.UserType;

@RestController
@RequestMapping("/api/userTypes")
public class UserTypeController {

    private final UserTypeClient userTypeClient;

    public UserTypeController(UserTypeClient userTypeClient) {
        this.userTypeClient = userTypeClient;
    }

    @GetMapping
    public List<UserType> getAll() {
        return userTypeClient.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserType> getById(@PathVariable String id) {
        return userTypeClient.getById(id);
    }

    @PostMapping
    public ResponseEntity<UserType> create(@RequestBody UserType userType) {
        return userTypeClient.create(userType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserType> update(@PathVariable String id,
                                           @RequestBody UserType userType) {
        return userTypeClient.update(id, userType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        return userTypeClient.delete(id);
    }
}
