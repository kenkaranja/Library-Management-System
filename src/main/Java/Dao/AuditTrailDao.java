package Dao;

import Entities.AuditTrail;

import javax.persistence.EntityManager;

public class AuditTrailDao extends CustomDao<AuditTrail> {
    public AuditTrailDao(EntityManager em) {
        super(em);
    }

    public boolean add(AuditTrail auditTrail) {
        return this.addCustom(auditTrail);
    }
}
