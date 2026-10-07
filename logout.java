package org.example.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/logout")
public class logout extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp){
        HttpSession session= req.getSession(false);
        if(session!=null){
            session.invalidate();
        }
        try {
            resp.sendRedirect("login.html");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
