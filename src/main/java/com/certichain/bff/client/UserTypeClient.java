package com.certichain.bff.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.certichain.bff.model.UserType;

@FeignClient(name = "usersubtypes-service", url = "http://localhost:8082/api/userTypes")
public interface UserTypeClient {

    @GetMapping
    public List<UserType> getAll();

    @GetMapping("/{id}")
    public ResponseEntity<UserType> getById(@PathVariable String id);

    @PostMapping
    public ResponseEntity<UserType> create(@RequestBody UserType userType);

    @PutMapping("/{id}")
    public ResponseEntity<UserType> update(@PathVariable String id, @RequestBody UserType userType);

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id);

}
