package dao;

import java.util.List;

import model.User;

public class LoginDAO {
	public User checkLogin(User user) {
		User tempUser = null;
		UserDAO userDAO = new UserDAO();
		List<User> userList = userDAO.getAllUsers();
		for (User s : userList) {
			if (user.getEmail().equals(s.getEmail()) && user.getPassword().equals(s.getPassword())) {
				tempUser = user;
			}
		}
		return tempUser;
	}
}
