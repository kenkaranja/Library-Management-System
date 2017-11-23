package Servlets;

import Entities.Book;
import Entities.IssuedBook;
import Entities.ReturnInfo;
import Entities.Student;
import Interfaces.ReturnInfoI;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "StudentPayDebt")
public class StudentPayDebt extends Custom {

    @EJB
    private ReturnInfoI returnInfoI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("ViewDebtListLibrarian.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session.getAttribute("Lusern") != null) {
            Book book = new Book();
            Student student = new Student();
            IssuedBook issuedBook = new IssuedBook();
            ReturnInfo returnInfo = new ReturnInfo();
            book.setBookId(get(req, "bookId"));
            student.setRegNo(get(req, "regno"));
            issuedBook.setBook(book);
            issuedBook.setStudent(student);
            returnInfo.setIssuedBook(issuedBook);
            returnInfo.setAmountPaid(Float.parseFloat(get(req,"amount")));
            returnInfo.setPaid("yes");
            if (returnInfoI.payDebt(returnInfo)) {
                resp.sendRedirect("StudentPayDebt");
            } else {
                resp.sendRedirect("StudentPayDebt");
            }

        } else

        {
            printWriter(resp, "<html><body><p>Login in! : <a href=\"LibrarianLogin\">Login</a> </p></body></html>");
        }

    }
}
