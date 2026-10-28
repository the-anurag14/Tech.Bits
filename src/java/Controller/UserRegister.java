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

@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        
        String user = request.getParameter("Username");
        if (user == null || user.trim().isEmpty()) {
            user = request.getParameter("username");
        }
        String pass = request.getParameter("password");
        String repass = request.getParameter("repassword");

        if (user == null || user.trim().isEmpty() || pass == null || pass.trim().isEmpty()) {
            pw.println("<script type=\"text/javascript\">");
            pw.println("alert('Username and Password cannot be empty!');");
            pw.println("window.location.href = \"userRegister.jsp\";");
            pw.println("</script>");
            return;
        }

        if (repass != null && !pass.equals(repass)) {
            pw.println("<script type=\"text/javascript\">");
            pw.println("alert('Passwords do not match!');");
            pw.println("window.location.href = \"userRegister.jsp\";");
            pw.println("</script>");
            return;
        }

        try (Connection con = DatabaseConnection.initializeDatabase()) {
            // Check if username already exists
            try (PreparedStatement checkPst = con.prepareStatement("SELECT username FROM login WHERE username = ?")) {
                checkPst.setString(1, user.trim());
                try (ResultSet rs = checkPst.executeQuery()) {
                    if (rs.next()) {
                        pw.println("<script type=\"text/javascript\">");
                        pw.println("alert('Username already exists! Please choose another.');");
                        pw.println("window.location.href = \"userRegister.jsp\";");
                        pw.println("</script>");
                        return;
                    }
                }
            }

            try (PreparedStatement pst = con.prepareStatement("INSERT INTO login VALUES (?, ?)")) {
                pst.setString(1, user.trim());
                pst.setString(2, pass);
                int i = pst.executeUpdate();
                if (i > 0) {
                    pw.println("<script type=\"text/javascript\">");
                    pw.println("alert('Registration Successful! Please login.');");
                    pw.println("window.location.href = \"index.jsp\";");
                    pw.println("</script>");
                } else {
                    pw.println("<script type=\"text/javascript\">");
                    pw.println("alert('Registration failed. Please try again.');");
                    pw.println("window.location.href = \"userRegister.jsp\";");
                    pw.println("</script>");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            pw.println("<script type=\"text/javascript\">");
            pw.println("alert('Database Error: " + e.getMessage().replace("'", "\\'") + "');");
            pw.println("window.location.href = \"userRegister.jsp\";");
            pw.println("</script>");
        }
    }
}
