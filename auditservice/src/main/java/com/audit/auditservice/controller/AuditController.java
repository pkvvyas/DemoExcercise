package com.audit.auditservice.controller;

import com.audit.auditservice.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/audits")
public class AuditController {

    @Autowired
    private AuditService auditService;

    @PostMapping
    public void logAudit(@RequestParam String action, @RequestParam String details) {
        auditService.logAudit(action, details);
    }
}