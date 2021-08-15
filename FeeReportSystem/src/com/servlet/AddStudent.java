package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
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
		HttpSession session = req.getSession(false);
		if (session == null || session.getAttribute("accountant") == null) {
			out.println("<h1>Not Accountant</h1>");
			req.getRequestDispatcher("accountantLogin.html").include(req, resp);

		} else {
			req.getRequestDispatcher("addStudentForm.html").include(req, resp);
		}
		out.println("</div>");
		req.getRequestDispatcher("footer.html").include(req, resp);
		out.println("</body>");
		out.println("</html>");
	}
}
