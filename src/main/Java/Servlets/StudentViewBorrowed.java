package Servlets;

import Entities.IssuedBook;
import Exceptions.BookException;
import Interfaces.StudentI;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "StudentViewBorrowed")
public class StudentViewBorrowed extends Custom {
    @EJB
    private
    StudentI studentI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session.getAttribute("Susern") != null) {
            try {
                List<IssuedBook> issueBookList = studentI.viewBorrowed((String) session.getAttribute("Susern"));
                if (issueBookList != null) {
                    req.setAttribute("booklist", issueBookList);
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("StudentViewBorrowed.jsp");
                    requestDispatcher.forward(req, resp);
                }
            } catch (BookException e) {
                e.printStackTrace();
            }
        }
    }
}
