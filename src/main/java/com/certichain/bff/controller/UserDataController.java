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

import com.certichain.bff.client.UserDataClient;
import com.certichain.bff.model.UserData;

@RestController
@RequestMapping("/api/userdata")
public class UserDataController {

    private final UserDataClient userDataClient;

    public UserDataController(UserDataClient userDataClient) {
        this.userDataClient = userDataClient;
    }

    @GetMapping
    public ResponseEntity<List<UserData>> getAll() {
        return userDataClient.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserData> getById(@PathVariable String id) {
        return userDataClient.getById(id);
    }

    @GetMapping("/userid/{userID}")
    public ResponseEntity<UserData> getByUserID(@PathVariable String userID) {
        return userDataClient.getByUserID(userID);
    }

    @PostMapping
    public ResponseEntity<UserData> create(@RequestBody UserData userData) {
        return userDataClient.create(userData);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserData> update(
            @PathVariable String id,
            @RequestBody UserData userData) {
        return userDataClient.update(id, userData);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        return userDataClient.delete(id);
    }

}
