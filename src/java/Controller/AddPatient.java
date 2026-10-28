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

@WebServlet("/AddPatient")
public class AddPatient extends HttpServlet {

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
            String gender = request.getParameter("gender");
            String phone = request.getParameter("Mobile");
            String city = request.getParameter("City");
            String email = request.getParameter("email");
            String age = request.getParameter("age");
            String address = request.getParameter("address");

            if (phone == null || phone.trim().isEmpty()) {
                pw.println("<script type=\"text/javascript\">");
                pw.println("alert('Mobile number is required!');");
                pw.println("window.location.href = \"addpatient.jsp\";");
                pw.println("</script>");
                return;
            }

            String DateAndTime = df2.format(todaysDate);

            try (Connection con = DatabaseConnection.initializeDatabase();
                 PreparedStatement pst = con.prepareStatement("INSERT INTO patient (fname, lname, gender, city, email, age, address, date, mobile) VALUES (?,?,?,?,?,?,?,?,?)")) {
                
                pst.setString(1, fname);
                pst.setString(2, lname);
                pst.setString(3, gender);
                pst.setString(4, city);
                pst.setString(5, email);
                pst.setString(6, age);
                pst.setString(7, address);
                pst.setString(8, DateAndTime);
                pst.setString(9, phone.trim());

                int i = pst.executeUpdate();
                if (i > 0) {
                    pw.println("<script type=\"text/javascript\">");
                    pw.println("alert('Patient Added Successfully!');");
                    pw.println("window.location.href = \"adminPatientList.jsp\";");
                    pw.println("</script>");
                } else {
                    pw.println("<script type=\"text/javascript\">");
                    pw.println("alert('Failed to add Patient!');");
                    pw.println("window.location.href = \"addpatient.jsp\";");
                    pw.println("</script>");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            pw.println("<script type=\"text/javascript\">");
            pw.println("alert('Error: " + ex.getMessage().replace("'", "\\'") + "');");
            pw.println("window.location.href = \"addpatient.jsp\";");
            pw.println("</script>");
        }
    }
}
