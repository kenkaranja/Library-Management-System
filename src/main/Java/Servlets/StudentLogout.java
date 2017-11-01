package Servlets;

import Entities.AuditTrail;
import Interfaces.AuditTrailI;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet(urlPatterns = "StudentLogout")
public class StudentLogout extends Custom {
    @EJB
    private AuditTrailI auditTrailI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session.getAttribute("Susern") != null) {
            AuditTrail auditTrail = new AuditTrail();
            auditTrail.setDate(new Date());
            auditTrail.setDetail("Logout");
            auditTrail.setUserType("Student");
            auditTrail.setUsername(String.valueOf(session.getAttribute("Susern")));
            if (auditTrailI.add(auditTrail)) {
                session.invalidate();
                resp.sendRedirect("HomePage");
            }
        } else {
            session.invalidate();
            resp.sendRedirect("HomePage");
        }
    }
}
