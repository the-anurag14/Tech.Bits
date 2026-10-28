package Controller;

import Database.DatabaseConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updatePatient")
public class updatePatient extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        
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
            pw.println("alert('Patient mobile number is required!');");
            pw.println("window.location.href = \"adminPatientList.jsp\";");
            pw.println("</script>");
            return;
        }

        try (Connection con = DatabaseConnection.initializeDatabase();
             PreparedStatement pst = con.prepareStatement("UPDATE patient SET fname = ?, lname = ?, gender = ?, city = ?, email = ?, age = ?, address = ? WHERE mobile = ?")) {
            
            pst.setString(1, fname);
            pst.setString(2, lname);
            pst.setString(3, gender);
            pst.setString(4, city);
            pst.setString(5, email);
            pst.setString(6, age);
            pst.setString(7, address);
            pst.setString(8, phone.trim());

            int i = pst.executeUpdate();
            if (i > 0) {
                pw.println("<script type=\"text/javascript\">");
                pw.println("alert('Patient Updated Successfully!');");
                pw.println("window.location.href = \"adminPatientList.jsp\";");
                pw.println("</script>");
            } else {
                pw.println("<script type=\"text/javascript\">");
                pw.println("alert('Update Failed! Record not found.');");
                pw.println("window.location.href = \"adminPatientList.jsp\";");
                pw.println("</script>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            pw.println("<script type=\"text/javascript\">");
            pw.println("alert('Error: " + e.getMessage().replace("'", "\\'") + "');");
            pw.println("window.location.href = \"adminPatientList.jsp\";");
            pw.println("</script>");
        }
    }
}
