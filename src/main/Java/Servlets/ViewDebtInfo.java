package Servlets;

import Entities.IssuedBook;
import Entities.ReturnInfo;
import Entities.Student;
import Interfaces.LibrarianI;
import Interfaces.StudentI;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ViewDebtInfo extends Custom {
    @EJB
    private StudentI studentI;

    @EJB
    private LibrarianI librarianI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = new Student();
        student.setRegNo(get(req, "studentregno"));
        Student student1 = studentI.viewById(student);
        ReturnInfo returnInfo = new ReturnInfo();
        IssuedBook issuedBook = new IssuedBook();
        issuedBook.setStudent(student1);
        returnInfo.setIssuedBook(issuedBook);
        List<ReturnInfo> returnInfos = librarianI.viewDebtInfo(returnInfo);
        if (student1 != null && returnInfos != null) {
            req.setAttribute("debtInfo", returnInfos);
            resp.sendRedirect("DebtInfo.jsp");
        } else {
            printWriter(resp, "\"<html><body><p>No Student! : <a href=\"LibrarianHomePage\">Home</a> </p></body></html>\"");
        }


    }
}
