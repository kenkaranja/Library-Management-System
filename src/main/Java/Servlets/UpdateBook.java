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
import java.util.List;

@WebServlet(urlPatterns = "UpdateBook")
public class UpdateBook extends Custom {
    @EJB
    private BookI bookI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("LibrarianViewBook");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = new Book();
        book.setBookId(get(req, "bookId"));
        try {
            Book b = bookI.viewById(book);
            if (b != null && b.getAvailable().equals("yes")) {
                HttpSession session = req.getSession(false);
                session.setAttribute("bookId", b.getBookId());
                session.setAttribute("isbn", b.getIsbn());
                session.setAttribute("bname", b.getBookName());
                session.setAttribute("author", b.getAuthor());
                session.setAttribute("edition", b.getEdition());
                session.setAttribute("category", b.getCategory());
                session.setAttribute("shelfNo", b.getShelfNo());
                session.setAttribute("row", b.getRowNo());
                session.setAttribute("colum", b.getColumNo());
                resp.sendRedirect("UpdatingBook");

            } else {
                printWriter(resp, "<html><body><p>Cannot Update!!! Book already issued! : <a href=\"LibrarianViewBook\">Back</a> </p></body></html>");
            }
        } catch (BookException e) {
            e.printStackTrace();
        }


    }
}
