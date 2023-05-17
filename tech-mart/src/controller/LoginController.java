package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDAO;
import model.User;
import utils.CookieUtils;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("views/auth/login.jsp").forward(request,response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String remember = request.getParameter("remember");
		LoginDAO loginDAO = new LoginDAO();
		User user = loginDAO.checkLogin(new User(username, password));

		if (user != null) {
			// This is point where user click the remember button
			if (remember != null) {
				CookieUtils.add("cookuser", username, 15, response);
				CookieUtils.add("cookpass", password, 15, response);
				CookieUtils.add("cookrem", remember, 15, response);
			}

			HttpSession session = request.getSession();

			if(user.getEmail().equals("admin@gmail.com")) {
				session.setAttribute("sessuser", user.getEmail());
				request.setAttribute("message", "Login success");
				RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/AdminHome.jsp");
				dispatcher.forward(request, response);
			}else {
				session.setAttribute("sessuser", user.getEmail());
				request.setAttribute("message", "Login success");
				request.setAttribute("user", user);
				response.sendRedirect("/");
			}
		} else {
			request.setAttribute("msg", "Authentication failure.");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/auth/login.jsp");
			requestDispatcher.forward(request, response);
		}
	}

}
