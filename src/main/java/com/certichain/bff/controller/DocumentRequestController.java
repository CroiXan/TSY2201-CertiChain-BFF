package com.certichain.bff.controller;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.certichain.bff.client.DocumentRequestClient;
import com.certichain.bff.model.DocumentRequest;

@RestController
@RequestMapping("/api/requests")
public class DocumentRequestController {

    private final DocumentRequestClient documentRequestClient;

    public DocumentRequestController(DocumentRequestClient documentRequestClient) {
        this.documentRequestClient = documentRequestClient;
    }

    @GetMapping
    public List<DocumentRequest> getAll() {
        return documentRequestClient.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DocumentRequest create(@RequestBody DocumentRequest docRequest) {
        return documentRequestClient.create(docRequest);
    }

    @PutMapping
    public ResponseEntity<DocumentRequest> update(@RequestBody DocumentRequest cambios) {
        return documentRequestClient.update(cambios);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        return documentRequestClient.delete(id);
    }

    @GetMapping("/requester/{requesterID}")
    public List<DocumentRequest> buscarPorRequester(
            @PathVariable String requesterID
    ) {
        return documentRequestClient.buscarPorRequester(requesterID);
    }

    @GetMapping("/issuer/{issuerID}")
    public List<DocumentRequest> buscarPorIssuer(
            @PathVariable String issuerID
    ) {
        return documentRequestClient.buscarPorIssuer(issuerID);
    }

    @GetMapping("/dates")
    public List<DocumentRequest> buscarPorFechaRango(
            @RequestParam("startDate")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date start,
            @RequestParam("endDate")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date end
    ) {
        return documentRequestClient.buscarPorFechaRango(start, end);
    }

    @GetMapping("/search")
    public List<DocumentRequest> search(
        @RequestParam(required = false) String requesterID,
        @RequestParam(required = false) String issuerID,
        @RequestParam(required = false)
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date startDate,
        @RequestParam(required = false)
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date endDate
    ) {
        return documentRequestClient.search(requesterID, issuerID, startDate, endDate);
    }

}
