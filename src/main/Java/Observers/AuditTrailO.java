package Observers;

import Events.AuditTrailEvent;
import Interfaces.AuditTrailI;

import javax.ejb.EJB;
import javax.enterprise.event.Observes;


public class AuditTrailO {
    @EJB
    AuditTrailI auditTrailI;

    public void observerEvent(@Observes AuditTrailEvent event) {
        auditTrailI.add(event.getAuditTrail());
    }
}
