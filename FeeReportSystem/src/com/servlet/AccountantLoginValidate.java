package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AccountantDao;

@WebServlet("/AccountantLoginValidate")
public class AccountantLoginValidate extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Accountant Section</title>");
		out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
		out.println("<link rel='stylesheet' href='style.css'/>");
		out.println("</head>");
		out.println("<body>");
		req.getRequestDispatcher("navaccountant.html").include(req, resp);
		out.println("<div class='container'>");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		boolean status = AccountantDao.loginValidate(email, password);
		if (status) {
			HttpSession session = req.getSession();
			session.setAttribute("accountant", "true");
			req.getRequestDispatcher("accountanthome.html").include(req, resp);
		} else {
			out.println("<div class='accValid'>");
			out.println("<h1>Accountant Login</h1>");
			out.println("<p class='accError'>Sorry,Username or password error</p>");
			req.getRequestDispatcher("accountantLogin.html").include(req, resp);
			out.println("</div>");

		}
		out.println("</div>");
		req.getRequestDispatcher("footer.html").include(req, resp);
		out.println("</body>");
		out.println("</html>");
	}
}
