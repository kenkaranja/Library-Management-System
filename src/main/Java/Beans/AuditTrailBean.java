package Beans;

import Dao.AuditTrailDao;
import Entities.AuditTrail;
import Interfaces.AuditTrailI;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Local
@Stateless
public class AuditTrailBean implements AuditTrailI{
    @PersistenceContext
    private EntityManager em;

    public boolean add(AuditTrail auditTrail) {
        AuditTrailDao auditTrailDao = new AuditTrailDao(em);
        return auditTrailDao.add(auditTrail);
    }
}
