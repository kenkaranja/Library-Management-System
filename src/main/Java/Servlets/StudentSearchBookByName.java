package Servlets;

import Entities.Book;
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

@WebServlet(urlPatterns = "SearchBookByName")
public class StudentSearchBookByName extends Custom {
    @EJB
    private StudentI studentI;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session.getAttribute("Susern") != null) {
            Book book = new Book();
            book.setBookName(get(req, "bName"));
            List<Book> bookList = null;
            try {
                bookList = studentI.viewBookByName(book);
                if (bookList != null) {
                    req.setAttribute("booklist", bookList);
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("StudentViewBookByName.jsp");
                    requestDispatcher.forward(req, resp);
                } else {
                    printWriter(resp, "\"<html><body><p>No books! : <a href=\"LibrarianHomePage\">Home</a> </p></body></html>\"");
                }
            } catch (BookException e) {
                e.printStackTrace();
            }
        } else {
            RequestDispatcher rd = req.getRequestDispatcher("HomePage");
            rd.forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("StudentViewBookByName.jsp");
        rd.forward(req, resp);
    }
}
