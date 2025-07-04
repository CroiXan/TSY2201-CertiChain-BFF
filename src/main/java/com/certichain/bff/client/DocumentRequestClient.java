package com.certichain.bff.client;

import java.util.Date;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.certichain.bff.model.DocumentRequest;

@FeignClient(name = "documentrequest-service", url = "http://certichaindocuments.ddns.net:8081/api/requests")
public interface DocumentRequestClient {

    @GetMapping
    public List<DocumentRequest> getAll();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DocumentRequest create(@RequestBody DocumentRequest docRequest);

    @PutMapping
    public ResponseEntity<DocumentRequest> update(@RequestBody DocumentRequest cambios);

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id);

    @GetMapping("/requester/{requesterID}")
    public List<DocumentRequest> buscarPorRequester(
            @PathVariable String requesterID
    );

    @GetMapping("/issuer/{issuerID}")
    public List<DocumentRequest> buscarPorIssuer(
            @PathVariable String issuerID
    );

    @GetMapping("/dates")
    public List<DocumentRequest> buscarPorFechaRango(
            @RequestParam("startDate")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date start,
            @RequestParam("endDate")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date end
    );

    @GetMapping("/search")
    public List<DocumentRequest> search(
        @RequestParam(required = false) String requesterID,
        @RequestParam(required = false) String issuerID,
        @RequestParam(required = false)
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date startDate,
        @RequestParam(required = false)
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date endDate
    );

}
