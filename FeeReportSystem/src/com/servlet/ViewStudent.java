package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDao;

@WebServlet("/ViewStudent")
public class ViewStudent extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>View Student</title>");
		out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
		out.println("<link rel='stylesheet' href='style.css'/>");
		out.println("</head>");
		out.println("<body>");
		req.getRequestDispatcher("navaccountant.html").include(req, resp);
		out.println("<div class='container'>");
		out.println("<h1>View Students</h1>");
		List<Student> list = StudentDao.getAllStudent();
		out.println("<table class='table table-bordered table-striped'>");
		out.println("<tr>");
		out.println("<th>Rollno</th>");
		out.println("<th>Name</th>");
		out.println("<th>Email</th>");
		out.println("<th>Gender</th>");
		out.println("<th>Course</th>");
		out.println("<th>Fee</th>");
		out.println("<th>Paid</th>");
		out.println("<th>Due</th>");
		out.println("<th>Address</th>");
		out.println("<th>Contact</th>");
		out.println("<th>Edit</th>");
		out.println("<th>Delete</th>");
		out.println("</tr>");
		for (Student st : list) {
			out.println("<tr>");
			out.println("<td>" + st.getRollno() + "</td>");
			out.println("<td>" + st.getName() + "</td>");
			out.println("<td>" + st.getEmail() + "</td>");
			out.println("<td>" + st.getGender() + "</td>");
			out.println("<td>" + st.getCourse() + "</td>");
			out.println("<td>" + st.getFee() + "</td>");
			out.println("<td>" + st.getPaid() + "</td>");
			out.println("<td>" + st.getDue() + "</td>");
			out.println("<td>" + st.getAddress() + "</td>");
			out.println("<td>" + st.getContact() + "</td>");
			out.println("<td><a href='EditStudent?rollno=" + st.getRollno() + "'>Edit</a></td>");
			out.println("<td><a href='DeleteStudent?rollno=" + st.getRollno() + "'>Delete</a></td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</div>");
		req.getRequestDispatcher("footer.html").include(req, resp);
		out.println("</body>");
		out.println("</html>");

	}
}
