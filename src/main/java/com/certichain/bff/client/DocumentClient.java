package com.certichain.bff.client;

import java.util.Date;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.certichain.bff.model.DocumentRequest;
import com.certichain.bff.model.SearchDocumentRequestInfo;

@FeignClient(name = "document-service", url = "http://certichaindocuments.ddns.net:8081/api/document")
public interface DocumentClient {

    @PostMapping
    public ResponseEntity<DocumentRequest> createRequest(@RequestBody DocumentRequest docRequest);

    @DeleteMapping
    public ResponseEntity<DocumentRequest> discardRequest(String Id);

    @GetMapping("/user/search")
    public ResponseEntity<List<SearchDocumentRequestInfo>> userSearchRequests(
            @RequestParam(required = false) String requesterID,
            @RequestParam(required = false) String issuerID,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date startDate,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date endDate);

    @GetMapping("/institution/search")
    public ResponseEntity<List<SearchDocumentRequestInfo>> institutionSearchRequests(
            @RequestParam(required = false) String requesterID,
            @RequestParam(required = false) String issuerID,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date startDate,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date endDate);


}