package Beans;

import Dao.LibrarianDao;
import Entities.AuditTrail;
import Entities.Librarian;
import Events.AuditTrailEvent;
import Interfaces.Authentication;
import Qualifiers.Login;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Login(Login.login.Librarian)
public class LibrarianAuth implements Authentication<Librarian> {
    @PersistenceContext
    private EntityManager em;

    @Inject
    private Event<AuditTrailEvent> event;

    public boolean login(Librarian librarian) {
        LibrarianDao librarianDao = new LibrarianDao(em);
        recordAudit(librarian);
        return librarianDao.login(librarian);
    }

    private void recordAudit(Librarian librarian) {
        AuditTrail auditTrail = new AuditTrail();
        AuditTrailEvent auditTrailEvent = new AuditTrailEvent();

        auditTrail.setUsername(librarian.getUsername());
        auditTrail.setUserType("Librarian");
        auditTrail.setDetail("Login");
        auditTrail.setDate(new java.util.Date());
        auditTrailEvent.setAuditTrail(auditTrail);
        event.fire(auditTrailEvent);
    }
}
