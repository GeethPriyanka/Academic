package lk.ac.pdn.ce.co324;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "MyOwnServlet",
        description = "This is my first annotated servlet",
        urlPatterns = {"/helloAnnotation", "/helloAnnotationExtension", "/helloWildcard/*"})

public class ServletWithAnnotation extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest reqest, HttpServletResponse response) throws ServletException, IOException {
        String userName = reqest.getParameter("username");
        response.getWriter().println("Hello "+ userName);
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
