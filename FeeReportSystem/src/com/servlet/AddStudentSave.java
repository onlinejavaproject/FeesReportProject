package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDao;

@WebServlet("/AddStudentSave")
public class AddStudentSave extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String gender = req.getParameter("gender");
		String course = req.getParameter("course");
		int fee = Integer.parseInt(req.getParameter("fee"));
		int paid = Integer.parseInt(req.getParameter("paid"));
		int due = Integer.parseInt(req.getParameter("due"));
		String address = req.getParameter("address");
		String contact = req.getParameter("contact");
		Student st = new Student(name, email, gender, course, fee, paid, due, address, contact);
		StudentDao.saveStudent(st);
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Add Student</title>");
		out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
		out.println("<link rel='stylesheet' href='style.css'/>");
		out.println("</head>");
		out.println("<body>");
		req.getRequestDispatcher("navaccountant.html").include(req, resp);
		out.println("<div class='container'>");
		out.println("<p class='add-success'>Student added successfully!!!</p>");
		req.getRequestDispatcher("addStudentForm.html").include(req, resp);
		out.println("</div>");
		req.getRequestDispatcher("footer.html").include(req, resp);
		out.println("</body>");
		out.println("</html>");

	}
}
