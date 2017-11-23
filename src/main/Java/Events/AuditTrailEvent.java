package Events;

import Entities.AuditTrail;

public class AuditTrailEvent {
    private AuditTrail auditTrail;

    public AuditTrail getAuditTrail() {
        return auditTrail;
    }

    public void setAuditTrail(AuditTrail auditTrail) {
        this.auditTrail = auditTrail;
    }
}
