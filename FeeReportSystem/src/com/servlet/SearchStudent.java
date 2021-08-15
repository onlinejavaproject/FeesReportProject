package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDao;

@WebServlet("/SearchStudent")
public class SearchStudent extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		int rollno = Integer.parseInt(req.getParameter("rollno"));
		Student st = StudentDao.getStudentByRollNo(rollno);

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Search Student</title>");
		out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
		out.println("<link rel='stylesheet' href='style.css'/>");
		out.println("</head>");
		out.println("<body>");
		req.getRequestDispatcher("navaccountant.html").include(req, resp);
		out.println("<div class='container'>");

		out.println("<h1>Search Student</h1>");
		if (st != null) {
			out.println("<table class='table table-bordered table-striped'>");
			out.print("<tr><td>Rollno:</td><td>" + st.getRollno() + "</td></tr>");
			out.print("<tr><td>Name:</td><td>" + st.getName() + "</td></tr>");
			out.print("<tr><td>Email:</td><td>" + st.getEmail() + "</td></tr>");
			out.print("<tr><td>Sex:</td><td>" + st.getGender() + "</td></tr>");
			out.print("<tr><td>Course:</td><td>" + st.getCourse() + "</td></tr>");
			out.print("<tr><td>Fee:</td><td>" + st.getFee() + "</td></tr>");
			out.print("</table>");

		} else {

			out.println("<p>No Record found for rollno " + rollno + "</p>");
		}

		out.println("</div>");
		req.getRequestDispatcher("footer.html").include(req, resp);
		out.println("</body>");
		out.println("</html>");
	}
}
