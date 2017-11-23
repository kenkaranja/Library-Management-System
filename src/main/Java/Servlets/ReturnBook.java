package Servlets;


import Entities.Book;
import Entities.IssuedBook;
import Entities.ReturnInfo;
import Entities.Student;
import Exceptions.BookException;
import Interfaces.BookI;
import Interfaces.IssuedBookI;
import Interfaces.ReturnInfoI;
import Interfaces.StudentI;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet(urlPatterns = "ReturnBook")
public class ReturnBook extends Custom {
    @EJB
    private
    BookI bookI;

    @EJB
    private
    IssuedBookI issuedBookI;

    @EJB
    private
    StudentI studentI;

    @EJB
    private
    ReturnInfoI returnInfoI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session.getAttribute("Lusern") != null) {
            RequestDispatcher rd = req.getRequestDispatcher("LibrarianViewIssued.jsp");
            rd.forward(req, resp);
        } else {
            printWriter(resp, "<html><body><p>Please Login! : <a href=\"HomePage\">Login</a> </p></body></html>");

        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session.getAttribute("Lusern") != null) {
            Student student = new Student();
            ReturnInfo returnInfo = new ReturnInfo();
            Book book = new Book();
            student.setRegNo(get(req, "studentregno"));
            book.setBookId(get(req, "bookid"));
            Student student1 = studentI.viewById(student);
            Book book1 = null;
            try {
                book1 = bookI.viewById(book);
                IssuedBook issuedBook1 = issuedBookI.viewEachIssued(get(req, "studentregno"), get(req, "bookid"));

                if (book1 != null && student1 != null && issuedBook1 != null) {
                    float latefee;
                    book1.setAvailable("yes");
                    issuedBook1.setReturnStatus("yes");
                    returnInfo.setTodayDate(new Date());
                    returnInfo.setIssuedBook(issuedBook1);
                    returnInfo.setAmountPaid(0);
                    returnInfo.setPaid("no");
                    //in milliseconds
                    long diff = new Date().getTime() - issuedBook1.getReturnDate().getTime();
                    if (diff < 0) {
                        latefee = 0;
                    } else {
                        int late = (int) (diff / (24 * 60 * 60 * 1000));
                        latefee = late * 5;
                        returnInfo.setLateFee(latefee);
                        returnInfo.setLate(late);
                    }

                    if (bookI.returnBook(book1, issuedBook1) && returnInfoI.add(returnInfo)) {
                        HttpSession session1 = req.getSession(false);
                        session1.setAttribute("issuedBook", issuedBook1);
                        printWriter(resp, "<html><body><p> Successfully Returned! : <a href=\"ReturnInfo\">View Return Info</a> </p></body></html>");
                    } else {
                        printWriter(resp, "<html><body><p> Problem occured! : <a href=\"ReturnBook\">ReturnBook</a> </p></body></html>");
                    }

                } else {
                    printWriter(resp, "<html><body><p> Problem occured! : <a href=\"ReturnBook\">ReturnBook</a> </p></body></html>");
                }
            } catch (BookException e) {
                e.printStackTrace();
            }

        } else {
            printWriter(resp, "<html><body><p>Please Login! : <a href=\"HomePage\">Login</a> </p></body></html>");

        }


    }


}
