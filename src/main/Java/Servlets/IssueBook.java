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
    BookI bookI;

    @EJB
    StudentI studentI;

    @EJB
    IssuedBookI issuedBookI;

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
            IssuedBook issuedBook = new IssuedBook();
            ReturnInfo returnInfo = new ReturnInfo();

            Book b = new Book();
            Student s = new Student();
            b.setBookId(get(req, "bookid"));
            s.setRegNo(get(req, "studentregno"));

            Book book = null;
            try {
                book = bookI.viewById(b);
                Student student = studentI.viewById(s);
                if (book != null && student != null) {
                    if (book.getAvailable().equals("no")) {
                        printWriter(resp, "<html><body><p> Already Issued! : <a href=\"LibrarianHomePage\">Home</a> </p></body></html>");
                    } else {
                        book.setAvailable("no");
                        issuedBook.setReturnStatus("no");
                        issuedBook.setIssueDate(Date.valueOf(get(req, "issuedate")));
                        issuedBook.setReturnDate(Date.valueOf(get(req, "returndate")));
                        issuedBook.setStudent(student);
                        issuedBook.setBook(book);

                        if (issuedBookI.issueBook(issuedBook, book)) {
                            printWriter(resp, "<html><body><p> Successfully Issued! : <a href=\"LibrarianHomePage\">Home</a> </p></body></html>");
                        } else {
                            RequestDispatcher rd = req.getRequestDispatcher("IssueBook");
                            rd.forward(req, resp);
                        }
                    }
                } else {
                    if (book == null) {
                        printWriter(resp, "<html><body><p> Book Doesn't exist! : <a href=\"AddBook\">Add Book</a> </p></body></html>");
                    }
                    if (student == null) {
                        printWriter(resp, "<html><body><p> Student Doesn't Exist! : <a href=\"AddStudent\">Add Student</a> </p></body></html>");
                    }
                }
            } catch (BookException e) {
                e.printStackTrace();
            }

        } else {
            printWriter(resp, "<html><body><p> Please Login! : <a href=\"HomePage\">Login</a> </p></body></html>");
        }

    }
}
