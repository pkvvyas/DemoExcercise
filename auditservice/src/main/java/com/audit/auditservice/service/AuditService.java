package com.audit.auditservice.service;

import com.audit.auditservice.model.Audit;
import com.audit.auditservice.repository.AuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuditService {

    @Autowired
    private AuditRepository auditRepository;

    public void logAudit(String action, String details) {
        Audit audit = new Audit();
        audit.setAction(action);
        audit.setDetails(details);
        audit.setTimestamp(LocalDateTime.now());
        auditRepository.save(audit);
    }
}