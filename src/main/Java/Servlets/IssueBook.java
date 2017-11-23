package Servlets;

import Entities.Book;
import Entities.IssuedBook;
import Entities.ReturnInfo;
import Entities.Student;
import Exceptions.BookException;
import Interfaces.BookI;
import Interfaces.IssuedBookI;
import Interfaces.StudentI;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;

@WebServlet(urlPatterns = "IssueBook")
public class IssueBook extends Custom {
    @EJB
    private BookI bookI;

    @EJB
    private StudentI studentI;

    @EJB
    private IssuedBookI issuedBookI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session.getAttribute("Lusern") != null) {
            RequestDispatcher rd = req.getRequestDispatcher("IssueBook.jsp");
            rd.forward(req, resp);
        } else {
            printWriter(resp, "<html><body><p> Please Login! : <a href=\"HomePage\">Login</a> </p></body></html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session.getAttribute("Lusern") != null) {
            try {
                IssuedBook issuedBook = new IssuedBook();

                Book b = new Book();
                Student s = new Student();
                b.setBookId(get(req, "bookid"));
                s.setRegNo(get(req, "studentregno"));
                issuedBook.setReturnStatus("no");
                issuedBook.setIssueDate(Date.valueOf(get(req, "issuedate")));
                issuedBook.setReturnDate(Date.valueOf(get(req, "returndate")));
                Book book = bookI.viewById(b);
                Student student = studentI.viewById(s);
                if (book != null && student != null) {
                    book.setAvailable("no");
                    issuedBook.setStudent(student);
                    issuedBook.setBook(book);
                    if (issuedBookI.issueBook(issuedBook, book)) {
                        printWriter(resp, "<html><body><p> Successfully Issued! : <a href=\"LibrarianHomePage\">Home</a> </p></body></html>");
                    } else {
                        RequestDispatcher rd = req.getRequestDispatcher("IssueBook");
                        rd.forward(req, resp);
                    }
                }
            } catch (BookException e) {
                e.printStackTrace();
            }

        }

    }
}