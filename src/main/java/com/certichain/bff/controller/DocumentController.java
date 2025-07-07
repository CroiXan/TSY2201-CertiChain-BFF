package com.certichain.bff.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.certichain.bff.client.DocumentClient;
import com.certichain.bff.client.DocumentFileClient;
import com.certichain.bff.model.DocumentRequest;
import com.certichain.bff.model.SearchDocumentRequestInfo;

@RestController
@RequestMapping("/api/document")
public class DocumentController {

    private final DocumentClient documentClient;
    private final DocumentFileClient documentFileClient;

    public DocumentController(DocumentClient documentClient, DocumentFileClient documentFileClient) {
        this.documentClient = documentClient;
        this.documentFileClient = documentFileClient;
    }
    
    @PostMapping
    public ResponseEntity<DocumentRequest> createRequest(@RequestBody DocumentRequest docRequest) {
        return documentClient.createRequest(docRequest);
    }

    @DeleteMapping
    public ResponseEntity<DocumentRequest> discardRequest(String Id) {
        return documentClient.discardRequest(Id);
    }

    @PostMapping("/upload/{id}")
    public ResponseEntity<DocumentRequest> uploadDocument(
            @PathVariable String id,
            @RequestParam("file") MultipartFile file) throws IOException {
        return documentFileClient.uploadDocument(id, file);
        
    }

    @GetMapping("/user/search")
    public ResponseEntity<List<SearchDocumentRequestInfo>> userSearchRequests(
            @RequestParam(required = false) String requesterID,
            @RequestParam(required = false) String issuerID,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date startDate,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date endDate){
        return documentClient.userSearchRequests(requesterID, issuerID, startDate, endDate);
    }

    @GetMapping("/institution/search")
    public ResponseEntity<List<SearchDocumentRequestInfo>> institutionSearchRequests(
            @RequestParam(required = false) String requesterID,
            @RequestParam(required = false) String issuerID,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date startDate,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date endDate){
        return documentClient.institutionSearchRequests(requesterID, issuerID, startDate, endDate);
    }

}
