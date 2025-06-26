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

import com.certichain.bff.model.DocumentType;

@FeignClient(name = "documenttypes-service", url = "http://certichaindata.ddns.net:8083/api/documenttypes")
public interface DocumentTypeClient {

    @GetMapping
    public List<DocumentType> getAll();

    @GetMapping("/{id}")
    public ResponseEntity<DocumentType> getById(@PathVariable String id);

    @GetMapping("/user/{userId}")
    public List<DocumentType> getByUserId(@PathVariable String userId);

    @PostMapping
    public ResponseEntity<DocumentType> create(@RequestBody DocumentType documentType);

    @PutMapping("/{id}")
    public ResponseEntity<DocumentType> update(@PathVariable String id, @RequestBody DocumentType documentType);

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id);

}
