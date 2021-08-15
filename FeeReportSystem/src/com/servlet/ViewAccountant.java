package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AccountantDao;

@WebServlet("/ViewAccountant")
public class ViewAccountant extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
		out.println("<h1>View Accountant</h1>");
		List<Accountant> list = AccountantDao.getAllAccountant();
		out.println("<table class='table table-bordered table-striped'>");
		out.println("<tr>");
		out.println("<th>Id</th>");
		out.println("<th>Name</th>");
		out.println("<th>Email</th>");
		out.println("<th>Password</th>");
		out.println("<th>Address</th>");
		out.println("<th>Contact</th>");
		out.println("<th>Edit</th>");
		out.println("<th>Delete</th>");
		out.println("</tr>");
		for (Accountant acc : list) {
			out.println("<tr>");
			out.println("<td>" + acc.getId() + "</td>");
			out.println("<td>" + acc.getName() + "</td>");
			out.println("<td>" + acc.getEmail() + "</td>");
			out.println("<td>" + acc.getPassword() + "</td>");
			out.println("<td>" + acc.getAddress() + "</td>");
			out.println("<td>" + acc.getContact() + "</td>");
			out.println("<td><a href='EditaccountantForm?id=" + acc.getId() + "'>Edit</a></td>");
			out.println("<td><a href='DeleteAccountant?id=" + acc.getId() + "'>Delete</a></td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</div>");
		req.getRequestDispatcher("footer.html").include(req, resp);
		out.println("</body>");
		out.println("</html>");
	}
}
