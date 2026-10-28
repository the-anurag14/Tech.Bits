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
import javax.servlet.http.HttpSession;

@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username == null || username.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            pw.println("<script type=\"text/javascript\">");
            pw.println("alert('Please enter both username and password!');");
            pw.println("window.location.href = \"index.jsp\";");
            pw.println("</script>");
            return;
        }

        try (Connection con = DatabaseConnection.initializeDatabase();
             PreparedStatement pst = con.prepareStatement("SELECT * FROM login WHERE username = ? AND password = ?")) {
            
            pst.setString(1, username.trim());
            pst.setString(2, password);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    HttpSession session = request.getSession();
                    session.setAttribute("user", username.trim());
                    pw.println("<script type=\"text/javascript\">");
                    pw.println("alert('Login Successful!');");
                    pw.println("window.location.href = \"UserHome.jsp\";");
                    pw.println("</script>");
                } else {
                    pw.println("<script type=\"text/javascript\">");
                    pw.println("alert('Username or Password is Incorrect!');");
                    pw.println("window.location.href = \"index.jsp\";");
                    pw.println("</script>");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            pw.println("<script type=\"text/javascript\">");
            pw.println("alert('Database Error: " + e.getMessage().replace("'", "\\'") + "');");
            pw.println("window.location.href = \"index.jsp\";");
            pw.println("</script>");
        }
    }
}
