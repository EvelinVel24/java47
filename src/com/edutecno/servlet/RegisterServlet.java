package com.edutecno.servlet;

import com.edutecno.dto.User;
import com.edutecno.dto.Role;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        // Crear un objeto User
        User user = new User(name, username, email, password, Arrays.asList(Role.ROLE_CLIENT));
        
        // Añadir el usuario como atributo de solicitud y redirigir a confirmación.jsp
        request.setAttribute("user", user);
        request.getRequestDispatcher("confirmacion.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("registro.jsp").forward(request, response);
    }
}
