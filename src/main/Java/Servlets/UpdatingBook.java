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

@WebServlet(urlPatterns = "UpdatingBook")
public class UpdatingBook extends Custom {
    @EJB
    private BookI bookI;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session.getAttribute("Lusern") != null) {
            Book book = new Book();
            book.setBookId(get(req, "bookid"));
            Book book1 = null;
            try {
                book1 = bookI.viewById(book);
                if (book1 != null && !book1.getAvailable().equals("no")) {
                    book1.setIsbn(get(req, "isbn"));
                    book1.setBookName(get(req, "bname"));
                    book1.setAuthor(get(req, "author"));
                    book1.setEdition(get(req, "edition"));
                    book1.setShelfNo(get(req, "shelfno"));
                    book1.setRowNo(get(req, "row"));
                    book1.setColumNo(get(req, "column"));
                    book1.setCategory(get(req, "category"));
                    try {
                        if (bookI.update(book1)) {
                            resp.sendRedirect("LibrarianViewBook");
                        } else {
                            resp.sendRedirect("LibrarianViewBook");
                        }
                    } catch (BookException e) {
                        e.printStackTrace();
                    }
                } else {
                    printWriter(resp, "<html><body><p>No Book Found! : <a href=\"LibrarianViewBook\">LibrarianViewBook</a> </p></body></html>");
                }
            } catch (BookException e) {
                e.printStackTrace();
            }


        } else {
            printWriter(resp, "<html><body><p>Please Login! : <a href=\"HomePage\">Login</a> </p></body></html>");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("UpdatingBook.jsp");
        rd.forward(req, resp);
    }
}
