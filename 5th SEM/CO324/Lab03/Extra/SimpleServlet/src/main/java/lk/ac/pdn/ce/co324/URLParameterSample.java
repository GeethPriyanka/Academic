package lk.ac.pdn.ce.co324;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet(urlPatterns = {"/sports"})

public class URLParameterSample extends HttpServlet { @Override
protected void doGet(HttpServletRequest reqest, HttpServletResponse response) throws ServletException, IOException {

    String param1 = reqest.getParameter("username");
    String param2 = reqest.getParameter("location");
    String[] paramArray = reqest.getParameterValues("sports");
    // Print The Response

    PrintWriter out = response.getWriter();
    out.write("<html><body><div id='serlvetResponse'>");
    out.write("<h2>Servlet HTTP Request Parameters Example</h2>");
    out.write("<p>param1: " + param1 + "</p>");
    out.write("<p>param2: " + param2 + "</p>");
    out.write("<p>paramArray: " + Arrays.toString(paramArray) + "</p>");
    out.write("</div></body></html>");
    out.close();

}

    @Override
    public void init() throws ServletException {
        System.out.println("Servlet " + this.getServletName() + " has started");
    }

    @Override
    public void destroy() {
        System.out.println("Servlet " + this.getServletName() + " has stopped");
    }

}
