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

import com.certichain.bff.model.UserData;

@FeignClient(name = "userdata-service", url = "http://certichaindata.ddns.net:8083/api/userdata")
public interface UserDataClient {

    @GetMapping
    public ResponseEntity<List<UserData>> getAll();

    @GetMapping("/{id}")
    public ResponseEntity<UserData> getById(@PathVariable String id);

    @GetMapping("/userid/{userID}")
    public ResponseEntity<UserData> getByUserID(@PathVariable String userID);

    @PostMapping
    public ResponseEntity<UserData> create(@RequestBody UserData userData);

    @PutMapping("/{id}")
    public ResponseEntity<UserData> update(@PathVariable String id, @RequestBody UserData userData);

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id);

}
