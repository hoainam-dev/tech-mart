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
import model.Category;

public class CategoryDAO {
	
	public CategoryDAO() {
	}
	
	public List<Category> getAllCategory() {
		List<Category> sl = new ArrayList<>();

		ConnectDB db = ConnectDB.getInstance();
		String sql = "SELECT * FROM categories order by id";
		try {
			Connection con = db.openConnection();

			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);

				String code = rs.getString(2);
				String name = rs.getString(3);
				String description = rs.getString(4);

				Category tmpCategory = new Category(id, code, name, description);
				sl.add(tmpCategory);
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
