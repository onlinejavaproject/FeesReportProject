package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDao;

@WebServlet("/EditStudent")
public class EditStudent extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		int rollno = Integer.parseInt(req.getParameter("rollno"));
		Student st = StudentDao.getStudentByRollNo(rollno);
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Edit Student Form</title>");
		out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
		out.println("<link rel='stylesheet' href='style.css'/>");
		out.println("</head>");
		out.println("<body>");
		req.getRequestDispatcher("navaccountant.html").include(req, resp);
		out.println("<div class='container'>");
		out.print("<h1>Edit Student Form</h1>");
		out.print("<form action='EditStudentSave' method='post'>");
		out.print("<table>");
		out.print("<tr><td><input type='hidden' name='rollno' value='" + st.getRollno() + "'/></td></tr>");
		out.print("<tr><td>Name:</td><td><input type='text' name='name' value='" + st.getName()
				+ "' required/></td></tr>");
		out.print("<tr><td>Email:</td><td><input type='email' name='email' value='" + st.getEmail()
				+ "' required/></td></tr>");
		out.print("<tr><td>Gender:</td><td><input type='text' name='sex' value='" + st.getGender()
				+ "' required/></td></tr>");
		out.print("<tr><td>Course:</td><td><input type='text' name='course' value='" + st.getCourse()
				+ "' required/></td></tr>");
		out.print("<tr><td>Fee:</td><td><input type='number' name='fee' value='" + st.getFee()
				+ "' required/></td></tr>");
		out.print("<tr><td>Paid:</td><td><input type='number' name='paid'  value='" + st.getPaid()
				+ "' required/></td></tr>");
		out.print("<tr><td>Due:</td><td><input type='number' name='due'  value='" + st.getDue()
				+ "' required/></td></tr>");
		out.print("<tr><td>Address:</td><td><textarea name='address' style='width:300px;height:100px;' required>"
				+ st.getAddress() + "</textarea></td></tr>");
		out.print("<tr><td>Contact No:</td><td><input type='number' name='contact' value='" + st.getContact()
				+ "' required/></td></tr>");
		out.print("<tr><td colspan='2' align='center'><input type='submit' value='Update Student'/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		out.println("</div>");
		req.getRequestDispatcher("footer.html").include(req, resp);
		out.println("</body>");
		out.println("</html>");

	}

}
