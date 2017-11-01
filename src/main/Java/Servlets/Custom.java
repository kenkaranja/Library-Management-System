package Servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Custom extends HttpServlet {
    public String get(HttpServletRequest request, String key) {
        return request.getParameter(key);
    }

    public void printWriter(HttpServletResponse response, String s) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print(s);
    }
}
