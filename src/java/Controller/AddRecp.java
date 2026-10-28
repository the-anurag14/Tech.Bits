package Controller;

import Database.DatabaseConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddRecp")
public class AddRecp extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        try {
            Date todaysDate = new Date();
            DateFormat df2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String phone = request.getParameter("Mobile");

            if (phone == null || phone.trim().isEmpty()) {
                pw.println("<script type=\"text/javascript\">");
                pw.println("alert('Mobile number is required!');");
                pw.println("window.location.href = \"addRecp.jsp\";");
                pw.println("</script>");
                return;
            }

            String DateAndTime = df2.format(todaysDate);

            try (Connection con = DatabaseConnection.initializeDatabase();
                 PreparedStatement pst = con.prepareStatement("INSERT INTO recp (fname, lname, mobile, date) VALUES (?,?,?,?)")) {
                
                pst.setString(1, fname);
                pst.setString(2, lname);
                pst.setString(3, phone.trim());
                pst.setString(4, DateAndTime);

                int i = pst.executeUpdate();
                if (i > 0) {
                    pw.println("<script type=\"text/javascript\">");
                    pw.println("alert('Receptionist Added Successfully!');");
                    pw.println("window.location.href = \"adminRecpList.jsp\";");
                    pw.println("</script>");
                } else {
                    pw.println("<script type=\"text/javascript\">");
                    pw.println("alert('Failed to add Receptionist!');");
                    pw.println("window.location.href = \"addRecp.jsp\";");
                    pw.println("</script>");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            pw.println("<script type=\"text/javascript\">");
            pw.println("alert('Error: " + ex.getMessage().replace("'", "\\'") + "');");
            pw.println("window.location.href = \"addRecp.jsp\";");
            pw.println("</script>");
        }
    }
}
