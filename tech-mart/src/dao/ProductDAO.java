package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import connectdb.ConnectDB;
import model.Cart;
import model.Category;
import model.Product;

public class ProductDAO {

	public ProductDAO() {
	}

	CategoryDAO categoryDAO = new CategoryDAO();
// Lits Product 
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

				Product tmpProduct = new Product(id, name, category, description, price, image);
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
	// Add product
	public void addProduct(Product product) throws ClassNotFoundException {
		int categoryId = 0;
		for (Category ca : categoryDAO.getAllCategory()) {
			if(Integer.parseInt(product.getCategory())==(ca.getId())){
				categoryId=ca.getId();
				}
			}
	ConnectDB db = ConnectDB.getInstance();
	Connection con;
	try {
		con = db.openConnection();
		PreparedStatement statement = con.prepareStatement("INSERT INTO products(id ,category_id, name, description, price, image)VALUES (?,?,?,?,?,?);");
		statement.setInt(1, product.getId());
		statement.setInt(2, categoryId);
		statement.setString(3, product.getName());
		statement.setString(4, product.getDescription());
		statement.setDouble(5, product.getPrice());
		statement.setString(6, product.getImage());
		statement.executeUpdate();
	} catch (SQLException ex) {
		Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
}
	// View a product
	public Product getProductById(int productId) {
		Product product = null;
		String sql = "SELECT * FROM products WHERE id = ?";
		ConnectDB db = ConnectDB.getInstance();
		try {
			// Kết nối tới CSDL
			Connection con = db.openConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1 , productId);
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
				product = new Product(id, category, name, description, price, image);
		}
		return product;
		} catch (SQLException | ClassNotFoundException e) {
					throw new RuntimeException(e);
				}

	}
	// Update product
	public void updateProduct(Product product) throws ClassNotFoundException {
		int categoryId = 0;
		for (Category ca : categoryDAO.getAllCategory()) {
			if(Integer.parseInt(product.getCategory())==(ca.getId())){
				categoryId=ca.getId();
			}
		}
		ConnectDB db = ConnectDB.getInstance();
		Connection con;
		String sql = "UPDATE products SET category_id=?,name=?, description=?,price=?,image=? WHERE id =? ;";
		try {
			con = db.openConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, categoryId);
			statement.setString(2, product.getName());
			statement.setString(3, product.getDescription());
			statement.setDouble(4, product.getPrice());
			statement.setString(5, product.getImage());
			statement.setInt(6, product.getId());
			statement.execute();
			statement.close();
			con.close();
		} catch (SQLException ex) {
			Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	// Delete product 
	public void deleteProducts(int id) {
		// create the connection

		try {
			ConnectDB db = ConnectDB.getInstance();
			Connection con = db.openConnection();
			// prepare the statement in order to excute the sql comments
			String sql = "DELETE FROM products WHERE id=?";
			PreparedStatement statement = con.prepareStatement(sql);
			// set parameter in the sql
			statement.setInt(1, id);
			// execute the sql
			statement.execute();
			con.close();
			statement.close();

		} catch (Exception ex) {
			Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
	// Get Total products
	public int  getTotal () {
		String sql = "SELECT COUNT(*) AS total FROM products";
		ConnectDB db = ConnectDB.getInstance();
		int totalCount = 0;
		try {
			// Kết nối tới CSDL
			Connection con = db.openConnection();
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				totalCount = rs.getInt("total");
			}
			
		} catch (SQLException | ClassNotFoundException e) {
			// Xử lý lỗi kết nối cơ sở dữ liệu hoặc câu lệnh SQL
			e.printStackTrace();
		}
		return totalCount;
	}
	
	public static void main(String[] args) {
		ProductDAO productDAO = new ProductDAO();
 		productDAO.getAllProduct();
	}
	public double getTotalCartPrice(ArrayList<Cart> cartList) throws ClassNotFoundException {
        ConnectDB db = ConnectDB.getInstance();
        String query = "  SELECT * FROM Products\n"
                            + "WHERE id=?;";
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        double sum = 0;
        try {
           
            if (cartList.size() > 0) {
                for (Cart item : cartList) {
                    con = db.openConnection();
                    statement = con.prepareStatement(query);
                    statement.setInt(1, item.getId());
                    rs = statement.executeQuery();
                    while (rs.next()) {
                        sum += rs.getDouble("price") * item.getQuantity();
                    }

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return sum;
    }
	
	public List<Cart> getCartProducts(ArrayList<Cart> cartList) {
		ConnectDB db = ConnectDB.getInstance();
        String query = "  SELECT * FROM products\n"
                            + "WHERE id=?;";
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<Cart> products = new ArrayList<>();
		try {
			if(cartList.size()>0) {
				for(Cart item:cartList) {
					con = db.openConnection();
					statement = con.prepareStatement(query);
                    statement.setInt(1, item.getId());
                    rs = statement.executeQuery();
                    
				 	while (rs.next()) {
				 		Cart row = new Cart();
				 		row.setId(rs.getInt("id"));
				 		row.setName(rs.getString("name"));
				 		row.setDescription(rs.getString("description"));
				 		row.setPrice(rs.getDouble("price")*item.getQuantity());
				 		row.setQuantity(item.getQuantity());
				 		row.setImage(rs.getString("image"));
				 		products.add(row);
				 	}
				}
			}
			
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}
		return products;
	}
}
