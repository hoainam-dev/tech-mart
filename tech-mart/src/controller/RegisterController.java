package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.User;


@WebServlet(name = "register", value = "/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("views/auth/register.jsp").forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmpassword = request.getParameter("confirmpassword");
		if(firstName!=null&&lastName!=null&&email!=null&&password!=null&&password.equals(confirmpassword)) {
			UserDAO userDAO = new UserDAO();
			boolean checkEmail = false;
			for (User userdb : userDAO.getAllUsers()) {
				if(email.equals(userdb.getEmail())) {
					checkEmail = true;
					break;
				}
			}
			if(checkEmail==false) {
				User user = new User(firstName, lastName, email, password);
				userDAO.addUser(user);
				request.setAttribute("message", "Register success");
				RequestDispatcher dispatcher = request.getRequestDispatcher("views/auth/login.jsp");
				dispatcher.forward(request, response);
			}
			else {
				request.setAttribute("msg", "Email already exists.");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/auth/register.jsp");
				requestDispatcher.forward(request, response);
			}
		}
		else {
			request.setAttribute("msg", "Registration failed. Please try again.");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/auth/register.jsp");
			requestDispatcher.forward(request, response);
		}
	}
}
