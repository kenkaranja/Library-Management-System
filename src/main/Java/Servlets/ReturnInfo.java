package Servlets;

import Dao.CustomDao;
import Entities.Book;
import Entities.IssuedBook;
import Entities.Student;
import Interfaces.BookI;
import Interfaces.ReturnInfoI;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "ReturnInfo")
public class ReturnInfo extends Custom {
    @EJB
    private ReturnInfoI returnInfoI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session.getAttribute("Lusern") != null) {
            IssuedBook issuedBook = (IssuedBook) session.getAttribute("issuedBook");
            Entities.ReturnInfo returnInfo = new Entities.ReturnInfo();
            returnInfo.setIssuedBook(issuedBook);
            List<Entities.ReturnInfo> returnInfoList = returnInfoI.viewReturnInfo(returnInfo);
            if (returnInfoList != null) {
                req.setAttribute("booklist", returnInfoList);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("ViewReturnInfo.jsp");
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

