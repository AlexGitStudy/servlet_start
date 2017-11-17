package sevlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doServ");
        PrintWriter pw=response.getWriter();
        pw.println("<html>"
                + "<head>"
                + "<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">"
                + "<title>Документ</title>"
                + "</head>"
                + "<body>"
                + "<p>Hello World!</p>"
                + "</body>"
                + "</html>");
    }

}
