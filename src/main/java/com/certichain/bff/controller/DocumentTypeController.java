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

import com.certichain.bff.client.DocumentTypeClient;
import com.certichain.bff.model.DocumentType;

@RestController
@RequestMapping("/api/documenttypes")
public class DocumentTypeController {

    private final DocumentTypeClient documentTypeClient;

    public DocumentTypeController(DocumentTypeClient documentTypeClient) {
        this.documentTypeClient = documentTypeClient;
    }

    @GetMapping
    public List<DocumentType> getAll() {
        return documentTypeClient.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentType> getById(@PathVariable String id) {
        return documentTypeClient.getById(id);
    }

    @GetMapping("/user/{userId}")
    public List<DocumentType> getByUserId(@PathVariable String userId) {
        return documentTypeClient.getByUserId(userId);
    }

    @PostMapping
    public ResponseEntity<DocumentType> create(@RequestBody DocumentType documentType) {
        return documentTypeClient.create(documentType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DocumentType> update(@PathVariable String id,
                                               @RequestBody DocumentType documentType) {
        return documentTypeClient.update(id, documentType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        return documentTypeClient.delete(id);
    }
}
