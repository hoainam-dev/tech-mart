package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import connectdb.ConnectDB;
import model.Category;
import model.Product;

public class ProductDAO {

	public ProductDAO() {
	}

	CategoryDAO categoryDAO = new CategoryDAO();

	public List<Product> getAllProduct() {
		List<Product> sl = new ArrayList<>();

		ConnectDB db = ConnectDB.getInstance();
		String sql = "SELECT * FROM products order by id";
		try {
			Connection con = db.openConnection();

			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				String category = null;
				int id = rs.getInt(1);

				int category_id = rs.getInt(2);
				String name = rs.getString(3);
				String description = rs.getString(4);
				double price = rs.getDouble(5);
				String image = rs.getString(6);

				for (Category cate : categoryDAO.getAllCategory()) {
					if (category_id == cate.getId()) {
						category = cate.getName();
					}
				}

				Product tmpProduct = new Product(id, category, name, description, price, image);
				sl.add(tmpProduct);
			}
			rs.close();
			statement.close();
			con.close();
		} catch (Exception ex) {
			Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return sl;
	}

//	public void addProduct(Product product) {
//		String sql = "INSERT INTO products(id, category_id, name, description, price) VALUES (?,?,?,?,?);";
//		ConnectDB db = ConnectDB.getInstance();
//		int categoryId = 0;
//		for (Category ca : categoryDAO.getAllCategory()) {
//			if(product.getCategory().equals(ca.getName())){
//				categoryId=ca.getId();
//			}
//		}
//		Connection con;
//		try {
//			con = db.openConnection();
//			PreparedStatement statement = con.prepareStatement(sql);
//			statement.setInt(1, product.getId());
//			statement.setInt(2, categoryId);
//			statement.setString(3, product.getName());
//			statement.setString(4, product.getDescription());
//			statement.setDouble(5, product.getPrice());
//			statement.execute();
//
//			statement.close();
//			con.close();
//
//		} catch (Exception ex) {
//			Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
//		}
//
//	}

}
