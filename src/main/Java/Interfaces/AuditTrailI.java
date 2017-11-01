package Interfaces;

import Entities.AuditTrail;

import javax.ejb.Local;

@Local
public interface AuditTrailI {
    boolean add(AuditTrail auditTrail);
}
