package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDao;

@WebServlet("/EditStudentSave")
public class EditStudentSave extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		int rollno = Integer.parseInt(req.getParameter("rollno"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String gender = req.getParameter("sex");
		String course = req.getParameter("course");
		int fee = Integer.parseInt(req.getParameter("fee"));
		int paid = Integer.parseInt(req.getParameter("paid"));
		int due = Integer.parseInt(req.getParameter("due"));
		String address = req.getParameter("address");
		String contact = req.getParameter("contact");

		Student st = new Student(rollno, name, email, gender, course, fee, paid, due, address, contact);
		StudentDao.updateStudent(st);
		resp.sendRedirect("ViewStudent");
	}
}
