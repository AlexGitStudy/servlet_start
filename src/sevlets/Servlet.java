package sevlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

public class Servlet extends HttpServlet {
    private int count= 0;



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<String> examples=new ArrayList<>();
        Enumeration en = request.getParameterNames();
        String p1 = "";
//        только числа
//        double a1 =Double.parseDouble(request.getParameter("p1"));
//        double a2 =Double.parseDouble(request.getParameter("p2"));
//        String calc= request.getParameter("do");

        count++;

        request.getSession().setAttribute("count",count);
        PrintWriter pw = response.getWriter();
        pw.println("<html>"
                + "<head>"
                + "<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">"
                + "<title>Servlet_Test</title>"
                + "</head>"
                + "<body>");



        pw.println("<h1>Session= " +request.getSession().getId() + "</h1>");
        while (en.hasMoreElements()) {
            String param = en.nextElement().toString();
             pw.println("<h1>" + param + " = " + request.getParameter(param) + "</h1>");
        }
        pw.println("<h1>Count= " +request.getSession().getAttribute("count") + "</h1>");
        for (int i = 0; i < count; i++) {

        }
            pw.println("</body>"
                    + "</html>");
        }

    }
