package Servlets;

import Entities.Book;
import Interfaces.BookI;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

@WebServlet(urlPatterns = "AddBook")
public class AddBook extends Custom {
    @EJB
    BookI bookI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session.getAttribute("Lusern") != null) {

            RequestDispatcher rd = req.getRequestDispatcher("AddBook.jsp");
            rd.forward(req, resp);
        } else {
            printWriter(resp, "<html><body><p>Please Login! : <a href=\"HomePage\">Login</a> </p></body></html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        CustomAddBook customAddBook = new CustomAddBook();
        if (session.getAttribute("Lusern") != null) {
            Book book = customAddBook.addBook(req);
            if (bookI.add(book)) {
                printWriter(resp, "<html><body><p> Successfully Added! : <a href=\"LibrarianHomePage\">Home</a> </p></body></html>");
            } else {
                RequestDispatcher rd = req.getRequestDispatcher("AddBook");
                rd.forward(req, resp);
            }
        } else {
            printWriter(resp, "<html><body><p>Please Login! : <a href=\"HomePage\">Login</a> </p></body></html>");
        }

    }


}
