package Servlets;

import Entities.Student;
import Interfaces.Authentication;
import Qualifiers.Login;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "StudentLogin")
public class StudentLogin extends Custom {
    @Inject
    @Login(Login.login.Student)
    private Authentication<Student> authentication;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = new Student();
        student.setRegNo(get(req, "regno"));
        student.setPassword(get(req, "password"));
        if (authentication.login(student)) {
            HttpSession session = req.getSession();
            session.setAttribute("Susern", get(req, "regno"));
            printWriter(resp, "<html><body><p> Successfully Login! : <a href=\"StudentHomePage\">Continue</a> </p></body></html>");
        } else {
            printWriter(resp, "<html><body><p> Wrong Username or Password! : <a href=\"HomePage\">Login</a> </p></body></html>");
        }
    }
}
