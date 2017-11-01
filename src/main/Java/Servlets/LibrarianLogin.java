package Servlets;

import Entities.Librarian;
import Interfaces.Authentication;
import Qualifiers.Login;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "LibrarianLogin")
public class LibrarianLogin extends Custom {
    @Inject
    @Login(Login.login.Librarian)
    private Authentication<Librarian> librarianAuthentication;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Librarian librarian = new Librarian();
        librarian.setUsername(get(req, "username"));
        librarian.setPassword(get(req, "password"));
        if (librarianAuthentication.login(librarian)) {
            HttpSession session = req.getSession();
            session.setAttribute("Lusern", get(req, "username"));
            printWriter(resp, "<html><body><p> Successfully Login! : <a href=\"LibrarianHomePage\">Home</a> </p></body></html>");
        } else {
            resp.sendRedirect("WrongCredentials");
        }
    }
}
