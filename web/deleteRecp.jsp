<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="Database.DatabaseConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String mob = request.getParameter("mob");
    if (mob != null && !mob.trim().isEmpty()) {
        try (Connection con = DatabaseConnection.initializeDatabase();
             PreparedStatement pst = con.prepareStatement("DELETE FROM recp WHERE mobile = ?")) {
            pst.setString(1, mob.trim());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    response.sendRedirect("adminRecpList.jsp");
%>
