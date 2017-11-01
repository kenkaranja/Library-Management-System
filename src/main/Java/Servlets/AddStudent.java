package Servlets;

import Entities.Student;
import Interfaces.StudentI;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "AddStudent")
public class AddStudent extends Custom {
    @EJB
    private StudentI studentI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("AddStudent.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        CustomStudent customStudent = new CustomStudent();
        Student student = customStudent.add(req);
        if (studentI.add(student)) {
            printWriter(resp, "<html><body><p> Successfully Added! : <a href=\"LibrarianHomePage\">Home</a> </p></body></html>");
        } else {
            RequestDispatcher rd = req.getRequestDispatcher("AddStudent");
            rd.forward(req, resp);
        }

    }
}
