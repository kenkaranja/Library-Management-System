package Servlets;

import Entities.Librarian;
import Interfaces.LibrarianI;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "AddLibrarian")
public class AddLibrarian extends Custom {
    @EJB
    private LibrarianI librarianI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("AddLibrarian.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");

        Librarian librarian = new Librarian();
        librarian.setLibrarianId(get(req, "librarianno"));
        librarian.setPassword(get(req, "password"));
        librarian.setUsername(get(req, "username"));
        librarian.setLibrarianName(get(req, "librarianname"));
        librarian.setEmail(get(req, "email"));
        if (librarianI.add(librarian)) {
            out.print("<html><body><p> Successfully Added! : <a href=\"LibrarianLogin\">Login</a> </p></body></html>");
        } else {
            RequestDispatcher rd = req.getRequestDispatcher("AddLibrarian");
            rd.forward(req, resp);
        }
    }
}
