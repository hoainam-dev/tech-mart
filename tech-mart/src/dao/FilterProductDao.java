package dao;

import connectdb.ConnectDB;
import model.Category;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.System.out;

public class FilterProductDao {
    public FilterProductDao() {
    }

    CategoryDAO categoryDAO = new CategoryDAO();
    public List<Product> getProductByPriceAndCate(String selectedCategory , String selectedPrice ) {
        List<Product> filter = new ArrayList<>();
        ConnectDB db = ConnectDB.getInstance();

        // Câu lệnh
        String sql = "SELECT * FROM products WHERE 1=1";
        if (selectedCategory != null && !selectedCategory.isEmpty()) {
            sql += " AND category_id = '" + selectedCategory + "'";
        }
        if (selectedPrice != null && !selectedPrice.isEmpty()) {
            switch (selectedPrice) {
                case "under-50":
                    sql += " AND price < 50000";
                    break;
                case "50-100":
                    sql += " AND price >= 50000 AND price <= 100000";
                    break;
                case "over-100":
                    sql += " AND price > 100000";
                    break;
            }
        }
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
                out.println(tmpProduct.getName());
                filter.add(tmpProduct);

            }
            rs.close();
            statement.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        out.println(filter.size());
        return filter;
    }

    public static void main(String[] args) {
        FilterProductDao filterProductDao = new FilterProductDao();
        filterProductDao.getProductByPriceAndCate("1", "over-100");
    }
}
