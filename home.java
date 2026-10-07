package org.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/home")
public class home extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession(false);
        if (session==null){
            resp.sendRedirect("login.html");
        }
        String username= (String) session.getAttribute("username");
        if(username==null){
            resp.sendRedirect("login.html");
            return;
        }
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h1> Welcome "+username +"</h1>");
        out.println("<br><br>");
        out.println("<a href='logout'>Logout</a>");
        out.println("</body>");
        out.println("</html>");



    }
}
