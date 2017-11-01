package Servlets;

import Entities.IssuedBook;
import Interfaces.LibrarianI;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "LibrarianViewIssued")
public class LibrarianViewIssued extends Custom {
    @EJB
    private LibrarianI librarianI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session.getAttribute("Lusern") != null) {
            List<IssuedBook> issueBookList = librarianI.viewIssued();
            if (issueBookList != null) {
                req.setAttribute("booklist", issueBookList);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("LibrarianViewIssued.jsp");
                requestDispatcher.forward(req, resp);
            } else {
                printWriter(resp, "\"<html><body><p>No books! : <a href=\"LibrarianHomePage\">Home</a> </p></body></html>\"");
            }
        } else {
            RequestDispatcher rd = req.getRequestDispatcher("HomePage");
            rd.forward(req, resp);
        }
    }
}
