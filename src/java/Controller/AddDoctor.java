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

@WebServlet("/AddDoctor")
public class AddDoctor extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        try {
            Date todaysDate = new Date();
            DateFormat df2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

            String sid = request.getParameter("id");
            if (sid == null || sid.trim().isEmpty()) {
                pw.println("<script type=\"text/javascript\">");
                pw.println("alert('Doctor ID is required!');");
                pw.println("window.location.href = \"addDoctor.jsp\";");
                pw.println("</script>");
                return;
            }
            int id = Integer.parseInt(sid.trim());
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String gender = request.getParameter("gender");
            String phone = request.getParameter("Mobile");
            String city = request.getParameter("City");
            String email = request.getParameter("email");
            String age = request.getParameter("age");
            String address = request.getParameter("address");
            String qualification = request.getParameter("qualification");

            String DateAndTime = df2.format(todaysDate);

            try (Connection con = DatabaseConnection.initializeDatabase();
                 PreparedStatement pst = con.prepareStatement("INSERT INTO doctor (id, fname, lname, gender, mobile, city, email, age, address, date, qualification) VALUES (?,?,?,?,?,?,?,?,?,?,?)")) {
                
                pst.setInt(1, id);
                pst.setString(2, fname);
                pst.setString(3, lname);
                pst.setString(4, gender);
                pst.setString(5, phone);
                pst.setString(6, city);
                pst.setString(7, email);
                pst.setString(8, age);
                pst.setString(9, address);
                pst.setString(10, DateAndTime);
                pst.setString(11, qualification);

                int i = pst.executeUpdate();
                if (i > 0) {
                    pw.println("<script type=\"text/javascript\">");
                    pw.println("alert('Doctor Added Successfully!');");
                    pw.println("window.location.href = \"adminDoctorList.jsp\";");
                    pw.println("</script>");
                } else {
                    pw.println("<script type=\"text/javascript\">");
                    pw.println("alert('Failed to add Doctor! Try Again Later.');");
                    pw.println("window.location.href = \"addDoctor.jsp\";");
                    pw.println("</script>");
                }
            }
        } catch (NumberFormatException nfe) {
            pw.println("<script type=\"text/javascript\">");
            pw.println("alert('Doctor ID must be a valid number!');");
            pw.println("window.location.href = \"addDoctor.jsp\";");
            pw.println("</script>");
        } catch (Exception ex) {
            ex.printStackTrace();
            pw.println("<script type=\"text/javascript\">");
            pw.println("alert('Error: " + ex.getMessage().replace("'", "\\'") + "');");
            pw.println("window.location.href = \"addDoctor.jsp\";");
            pw.println("</script>");
        }
    }
}
