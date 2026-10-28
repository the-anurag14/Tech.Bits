<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="Database.DatabaseConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String sid = request.getParameter("id");
    if (sid != null && !sid.trim().isEmpty()) {
        try (Connection con = DatabaseConnection.initializeDatabase();
             PreparedStatement pst = con.prepareStatement("DELETE FROM doctor WHERE id = ?")) {
            pst.setInt(1, Integer.parseInt(sid.trim()));
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    response.sendRedirect("adminDoctorList.jsp");
%>
