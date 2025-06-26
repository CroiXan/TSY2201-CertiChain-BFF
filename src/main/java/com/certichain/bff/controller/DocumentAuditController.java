package com.certichain.bff.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.certichain.bff.client.DocumentAuditClient;
import com.certichain.bff.model.PrivateDocumentAuditLog;
import com.certichain.bff.model.PublicDocumentAuditLog;

@RestController
@RequestMapping("/api/audit")
public class DocumentAuditController {

    private final DocumentAuditClient documentAuditClient;

    public DocumentAuditController(DocumentAuditClient documentAuditClient) {
        this.documentAuditClient = documentAuditClient;
    }

    @GetMapping("/private")
    public List<PrivateDocumentAuditLog> queryPrivateAuditLogs(
            @RequestParam String filterType,
            @RequestParam String filterValue,
            @RequestParam String startDate,
            @RequestParam String endDate) {
        return documentAuditClient.queryPrivateAuditLogs(filterType, filterValue, startDate, endDate);
    }

    @GetMapping("/public")
    public List<PublicDocumentAuditLog> queryAuditLogs(
            @RequestParam String filterType,
            @RequestParam String filterValue,
            @RequestParam String startDate,
            @RequestParam String endDate) {
        return documentAuditClient.queryAuditLogs(filterType, filterValue, startDate, endDate);
    }

}
