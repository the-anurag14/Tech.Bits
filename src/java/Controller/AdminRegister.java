package Controller;

import Database.DatabaseConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdminRegister")
public class AdminRegister extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        String repass = request.getParameter("re_pass");

        if (email == null || email.trim().isEmpty() || pass == null || pass.trim().isEmpty()) {
            pw.println("<script type=\"text/javascript\">");
            pw.println("alert('Email and Password cannot be empty!');");
            pw.println("window.location.href = \"adminRegister.jsp\";");
            pw.println("</script>");
            return;
        }

        if (repass != null && !pass.equals(repass)) {
            pw.println("<script type=\"text/javascript\">");
            pw.println("alert('Passwords do not match!');");
            pw.println("window.location.href = \"adminRegister.jsp\";");
            pw.println("</script>");
            return;
        }

        try (Connection con = DatabaseConnection.initializeDatabase()) {
            // Check if admin email already exists
            try (PreparedStatement checkPst = con.prepareStatement("SELECT email FROM adminreg WHERE email = ?")) {
                checkPst.setString(1, email.trim());
                try (ResultSet rs = checkPst.executeQuery()) {
                    if (rs.next()) {
                        pw.println("<script type=\"text/javascript\">");
                        pw.println("alert('Admin email already registered! Please login.');");
                        pw.println("window.location.href = \"adminLogin.jsp\";");
                        pw.println("</script>");
                        return;
                    }
                }
            }

            try (PreparedStatement pst = con.prepareStatement("INSERT INTO adminreg VALUES (?, ?)")) {
                pst.setString(1, email.trim());
                pst.setString(2, pass);
                int i = pst.executeUpdate();
                if (i > 0) {
                    pw.println("<script type=\"text/javascript\">");
                    pw.println("alert('Admin Registered Successfully! Please login.');");
                    pw.println("window.location.href = \"adminLogin.jsp\";");
                    pw.println("</script>");
                } else {
                    pw.println("<script type=\"text/javascript\">");
                    pw.println("alert('Registration failed. Try again.');");
                    pw.println("window.location.href = \"adminRegister.jsp\";");
                    pw.println("</script>");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            pw.println("<script type=\"text/javascript\">");
            pw.println("alert('Database Error: " + e.getMessage().replace("'", "\\'") + "');");
            pw.println("window.location.href = \"adminRegister.jsp\";");
            pw.println("</script>");
        }
    }
}
