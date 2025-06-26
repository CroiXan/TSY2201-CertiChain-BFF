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

import com.certichain.bff.client.UserSubTypeClient;
import com.certichain.bff.model.UserSubType;

@RestController
@RequestMapping("/api/userSubTypes")
public class UserSubTypeController {

    private final UserSubTypeClient userSubTypeClient;

    public UserSubTypeController(UserSubTypeClient userSubTypeClient) {
        this.userSubTypeClient = userSubTypeClient;
    }

    @GetMapping
    public List<UserSubType> getAll() {
        return userSubTypeClient.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserSubType> getById(@PathVariable String id) {
        return userSubTypeClient.getById(id);
    }

    @PostMapping
    public ResponseEntity<UserSubType> create(@RequestBody UserSubType userSubType) {
        return userSubTypeClient.create(userSubType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserSubType> update(@PathVariable String id,
                                              @RequestBody UserSubType userSubType) {
        return userSubTypeClient.update(id, userSubType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        return userSubTypeClient.delete(id);
    }

}
