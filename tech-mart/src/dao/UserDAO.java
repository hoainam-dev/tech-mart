package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import connectdb.ConnectDB;
import connectdb.TestDB;
import model.User;

public class UserDAO {
	
	public UserDAO() {
	}
	
	public List<User> getAllUsers() {
		List<User> sl = new ArrayList<>();

		ConnectDB db = ConnectDB.getInstance();
		String sql = "SELECT * FROM users order by id";
		try {
			Connection con = db.openConnection();

			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);

				String fisrtName = rs.getString(2);
				String lartName = rs.getString(3);
				String email = rs.getString(4);
				String password = rs.getString(5);

				User tmpUser = new User(id, fisrtName, lartName, email, password);
				sl.add(tmpUser);
			}
			rs.close();
			statement.close();
			con.close();
		} catch (Exception ex) {
			Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
		}
		return sl;
	}


	public void addUser(User user) {

		String sql = "INSERT INTO users(firstname, lastname, email, password)\n" + "VALUES (?, ?, ?, ?);";
		ConnectDB db = ConnectDB.getInstance();
		Connection con = null;
		PreparedStatement statement = null;
		try {

			con = db.openConnection();
			statement = con.prepareStatement(sql);
			statement.setString(1, user.getFirstName());
			statement.setString(2, user.getLastName());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getPassword());
			statement.execute();
			
			statement.close();
			con.close();
		} catch (Exception ex) {
			Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
}
