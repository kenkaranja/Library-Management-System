package Servlets;

import Entities.ReturnInfo;
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

@WebServlet(urlPatterns = "LibrarianViewReturnInfo")
public class LibrarianViewReturnInfo extends Custom {
    @EJB
    private ReturnInfoI returnInfoI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session.getAttribute("Lusern") != null) {
            List<ReturnInfo> returnInfoList = null;
            returnInfoList = returnInfoI.viewAllDebt();
            if (returnInfoList != null) {
                req.setAttribute("debtList", returnInfoList);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("ViewDebtListLibrarian.jsp");
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
