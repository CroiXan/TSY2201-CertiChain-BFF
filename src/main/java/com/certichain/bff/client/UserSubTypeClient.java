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

import com.certichain.bff.model.UserSubType;

@FeignClient(name = "usersubtypes-service", url = "http://certichaindata.ddns.net:8083/api/userSubTypes")
public interface UserSubTypeClient {

    @GetMapping
    public List<UserSubType> getAll();

    @GetMapping("/{id}")
    public ResponseEntity<UserSubType> getById(@PathVariable String id);

    @PostMapping
    public ResponseEntity<UserSubType> create(@RequestBody UserSubType userSubType);

    @PutMapping("/{id}")
    public ResponseEntity<UserSubType> update(@PathVariable String id, @RequestBody UserSubType userSubType);

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id);

}
