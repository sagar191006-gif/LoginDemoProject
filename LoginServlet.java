package com.demo;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//Since using tomcat 10.1 changing "javax" imports to "jakarta"

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "1234";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password)) {

            // Success → create session
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            // Forward to welcome page
            RequestDispatcher rd = request.getRequestDispatcher("/Welcome.jsp");
            rd.forward(request, response);

        } else {
            // Fail → send back with error
            request.setAttribute("error", "Invalid username or password!");
            RequestDispatcher rd = request.getRequestDispatcher("/index.html");
            rd.forward(request, response);
        }
    }

    // Protect against direct GET access
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("index.html");
    }
}
