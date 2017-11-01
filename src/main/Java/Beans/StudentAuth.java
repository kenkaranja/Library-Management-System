package Beans;

import Dao.StudentDao;
import Entities.AuditTrail;
import Entities.Student;
import Events.AuditTrailEvent;
import Interfaces.Authentication;
import Qualifiers.Login;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Login(Login.login.Student)
public class StudentAuth implements Authentication<Student> {
    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private Event<AuditTrailEvent> event;

    public boolean login(Student student) {
        StudentDao studentDao = new StudentDao(entityManager);
        recordAudit(student);
        return studentDao.login(student);
    }

    private void recordAudit(Student student) {
        AuditTrail auditTrail = new AuditTrail();
        AuditTrailEvent auditTrailEvent = new AuditTrailEvent();
        java.util.Date date = new java.util.Date();

        auditTrail.setUsername(student.getRegNo());
        auditTrail.setUserType("Student");
        auditTrail.setDetail("Login");
        auditTrail.setDate(date);
        auditTrailEvent.setAuditTrail(auditTrail);
        event.fire(auditTrailEvent);
    }
}
