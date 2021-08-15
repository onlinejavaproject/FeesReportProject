package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AccountantDao;

@WebServlet("/AddAccountant")
public class AddAccountantSave extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title> Accountant Added</title>");
		out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
		out.println("<link rel='stylesheet' href='style.css'/>");

		out.println("</head>");
		out.println("<body>");
		req.getRequestDispatcher("navadmin.html").include(req, resp);
		out.println("<div class='container'>");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String address = req.getParameter("address");
		String contact = req.getParameter("contact");
		Accountant acc = new Accountant(name, email, password, contact, address);
		AccountantDao.saveAccountant(acc);
		out.println("<h1>Add Accountant Form</h1>");
		out.println("<p class='add-success'>Accountant is added successfully!!</p>");
		req.getRequestDispatcher("accountantForm.html").include(req, resp);
		out.println("</div>");
		req.getRequestDispatcher("footer.html").include(req, resp);
		out.println("</body>");
		out.println("</html>");

	}
}
