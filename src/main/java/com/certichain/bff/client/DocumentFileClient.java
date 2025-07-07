package com.certichain.bff.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.certichain.bff.client.config.FeignFormConfig;
import com.certichain.bff.model.DocumentRequest;

@FeignClient(name = "document-file-service", url = "http://certichaindocuments.ddns.net:8081/api/document", configuration = FeignFormConfig.class)
public interface DocumentFileClient {

    @PostMapping(value = "/upload/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<DocumentRequest> uploadDocument(
            @PathVariable String id,
            @RequestPart("file") MultipartFile file);
}
