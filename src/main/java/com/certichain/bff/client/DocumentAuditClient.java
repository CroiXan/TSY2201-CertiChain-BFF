package com.certichain.bff.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.certichain.bff.model.PrivateDocumentAuditLog;
import com.certichain.bff.model.PublicDocumentAuditLog;

@FeignClient(name = "audit-service", url = "http://certichaindocuments.ddns.net:8081/api/audit")
public interface DocumentAuditClient {

    @GetMapping("/privatedocuments/audit")
    public List<PrivateDocumentAuditLog> queryPrivateAuditLogs(
            @RequestParam String filterType,
            @RequestParam String filterValue,
            @RequestParam String startDate,
            @RequestParam String endDate
    );

    @GetMapping("/publicdocuments/audit")
    public List<PublicDocumentAuditLog> queryAuditLogs(
        @RequestParam String filterType,
        @RequestParam String filterValue,
        @RequestParam String startDate,
        @RequestParam String endDate
    );

}
