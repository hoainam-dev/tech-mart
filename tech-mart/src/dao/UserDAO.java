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

				String name = rs.getString(2);
				String email = rs.getString(3);
				String password = rs.getString(4);

				User tmpUser = new User(id, name, email, password);
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
}
