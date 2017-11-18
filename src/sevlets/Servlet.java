package sevlets;

import mathHelp.CalcOperations;
import mathHelp.MathemHelpEn;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

public class Servlet extends HttpServlet {
    private int count = 0;


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        ArrayList<String> examples = new ArrayList<>();
//        Enumeration en = request.getParameterNames();


//        только числа


        count++;

//        request.getSession().setAttribute("count", count);
        PrintWriter pw = response.getWriter();
        pw.println("<html>"
                + "<head>"
                + "<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">"
                + "<title>Servlet_Test</title>"
                + "</head>"
                + "<body>");

        try {
            double a1 = Double.parseDouble(request.getParameter("p1"));
            double a2 = Double.parseDouble(request.getParameter("p2"));
            String calc = request.getParameter("do");

            HttpSession session = request.getSession(true);

            MathemHelpEn helpEn= MathemHelpEn.valueOf(request.getParameter("do").toUpperCase());

            double result=calcResult(a1, a2, helpEn);
            pw.println("<h1>User Id = " + request.getSession().getId() + "</h1>");

            if (session.isNew())
//                examples.clear();
                session.setAttribute("formula1", new ArrayList<>());
//            else
//                examples = (ArrayList<String>) session.getAttribute("formula1");
            ArrayList<String> examples= new ArrayList<>((ArrayList<String>) session.getAttribute("formula1"));
            examples.add("<h1>" + a1 + " " + helpEn.getStringValue() + " " + a2 + " = " + result + "</h1>");
            session.setAttribute("formula1",examples);
            for (String formula: examples
                    ) {
                pw.println(formula);
            }

            pw.println("<h1>Size = " + examples.size() + "</h1>");

        } catch (Exception e) {
            pw.println("<h1>Hello world!</h1>");

        }
        finally {
//            pw.println("<h1>Count= " + request.getSession().getAttribute("count") + "</h1>");
            pw.println("</body>"
                    + "</html>");
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       processRequest(request,response);
    }

    private double calcResult(double a, double b, MathemHelpEn opType) {

        CalcOperations calcOperations = new CalcOperations();
        switch (opType.getStringValue()){
            case "+":
                return CalcOperations.add(a,b);
            case "-":
                return CalcOperations.divide(a,b);
            case "*":
                return CalcOperations.multiply(a,b);
            case "/":
                return CalcOperations.subtract(a,b);

        }

        return 0;


    }

}
