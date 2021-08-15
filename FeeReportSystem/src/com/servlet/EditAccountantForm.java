package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AccountantDao;

@WebServlet("/EditaccountantForm")
public class EditAccountantForm extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		int id = Integer.parseInt(req.getParameter("id"));
		Accountant acc = AccountantDao.getAccountantById(id);
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Edit Accountant</title>");
		out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
		out.println("<link rel='stylesheet' href='style.css'/>");
		out.println("</head>");
		out.println("<body>");

		req.getRequestDispatcher("navadmin.html").include(req, resp);
		out.println("<div class='container'>");
		out.println("<h1>Edit Accountant</h1>");
		out.println("<form action='EditAccountantSave' method='post'>");
		out.println("<table>");
		out.println("<tr><td><input type='hidden' name='id' value='" + acc.getId() + "'></td></tr>");
		out.println("<tr><td>Name:</td><td><input type='text' name='name' value='" + acc.getName()
				+ "' required></td></tr>");
		out.println("<tr><td>Email:</td><td><input type='email' name='email' value='" + acc.getEmail()
				+ "' required></td></tr>");
		out.println("<tr><td>Password:</td><td><input type='password' name='password' value='" + acc.getPassword()
				+ "' required></td></tr>");
		out.println("<tr><td>Address:</td><td><textarea name='address' style='width:300px;height:300px;' required>"
				+ acc.getAddress() + "</textarea></td></tr>");
		out.println("<tr><td>Contact:</td><td><input type='number' name='contact' value='" + acc.getContact()
				+ "' required></td></tr>");
		out.println(
				"<tr><td colspan='2' align='center'><input type='submit' value='Update Accountant' class='btn btn-default'></td></tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</div>");
		req.getRequestDispatcher("footer.html").include(req, resp);
		out.println("</body>");
		out.println("</html>");

	}
}
