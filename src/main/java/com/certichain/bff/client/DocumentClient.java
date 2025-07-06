package com.certichain.bff.client;

import java.util.Date;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.certichain.bff.config.FeignConfig;
import com.certichain.bff.model.DocumentRequest;
import com.certichain.bff.model.SearchDocumentRequestInfo;

@FeignClient(name = "document-service", url = "http://certichaindocuments.ddns.net:8081/api/document", configuration = FeignConfig.class)
public interface DocumentClient {

    @PostMapping
    public ResponseEntity<DocumentRequest> createRequest(@RequestBody DocumentRequest docRequest);

    @DeleteMapping
    public ResponseEntity<DocumentRequest> discardRequest(String Id);

    @PostMapping(value = "/upload/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<DocumentRequest> uploadDocument(
            @PathVariable String id,
            @RequestPart("file") MultipartFile file);

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