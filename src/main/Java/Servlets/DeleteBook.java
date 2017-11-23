package Servlets;

import Entities.Book;
import Exceptions.BookException;
import Interfaces.BookI;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "DeleteBook")
public class DeleteBook extends Custom {
    @EJB
    private BookI bookI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session.getAttribute("Lusern") != null) {
            RequestDispatcher rd = req.getRequestDispatcher("ViewBookLibrarian.jsp");
            rd.forward(req, resp);
        } else {
            printWriter(resp, "<html><body><p> Please Login! : <a href=\"HomePage\">Home</a> </p></body></html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session.getAttribute("Lusern") != null) {
            Book book = new Book();
            book.setBookId(get(req, "bookId"));

            try {
                Book book1 = bookI.viewById(book);
                if (book1 != null && book1.getAvailable().equals("yes")) {
                    if (bookI.deleteBook(book1)) {
                        resp.sendRedirect("LibrarianViewBook");
                    } else {
                        resp.sendRedirect("DeleteBook");
                    }
                }
                else {
                    printWriter(resp,"<html><body><p> Cannot Delete!!! Book already issued! : <a href=\"LibrarianViewBook\">Back</a> </p></body></html>");
                }

            } catch (BookException e) {
                e.printStackTrace();
            }
        } else {
            printWriter(resp, "<html><body><p> Please Login! : <a href=\"HomePage\">Home</a> </p></body></html>");
        }


    }
}
