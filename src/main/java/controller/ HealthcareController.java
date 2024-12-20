package com.example.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Controller servlet for Healthcare Management System
 */
@WebServlet("/healthcare")
public class HealthcareController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public HealthcareController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "default";
        }

        switch (action) {
            case "manageUsers":
                manageUsers(request, response);
                break;
            case "manageDoctors":
                manageDoctors(request, response);
                break;
            case "managePatients":
                managePatients(request, response);
                break;
            default:
                showHomePage(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void manageUsers(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.getWriter().println("<h2>Manage Users Page</h2>");
        response.getWriter().println("<p>Feature to add, view, or delete users.</p>");
    }

    private void manageDoctors(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.getWriter().println("<h2>Manage Doctors Page</h2>");
        response.getWriter().println("<p>Feature to add, view, or delete doctors.</p>");
    }

    private void managePatients(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.getWriter().println("<h2>Manage Patients Page</h2>");
        response.getWriter().println("<p>Feature to add, view, or delete patients.</p>");
    }

    private void showHomePage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.getWriter().println("<h1>Welcome to Healthcare Management System</h1>");
        response.getWriter().println("<a href='healthcare?action=manageUsers'>Manage Users</a><br>");
        response.getWriter().println("<a href='healthcare?action=manageDoctors'>Manage Doctors</a><br>");
        response.getWriter().println("<a href='healthcare?action=managePatients'>Manage Patients</a><br>");
    }
}
