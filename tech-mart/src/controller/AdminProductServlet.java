package controller;

import dao.CategoryDAO;
import dao.ProductDAO;
import model.Category;
import model.Product;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "AdminProductServlet", value = "/admin/product")
public class AdminProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String theCommand = request.getParameter("command");
            if (theCommand == null) {
                theCommand = "LIST";
            }
            switch (theCommand) {
                case "LIST":
                    ListProduct(request, response);
                    break;
                case "VIEW":
                    ViewProduct(request, response);
                    break;
                case "LOADUPDATE":
                    LoadProductToUpDate(request, response);
                    break;
                case "UPDATE":
                    UpdateProduct(request, response);
                    break;
                case "DELETE":
                    Delete(request, response);
                    break;
                default:
                    ListProduct(request, response);
            }

        } catch (Exception ex) {

            Logger.getLogger(AdminProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    // List product
    private void ListProduct (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDAO productDAO = new ProductDAO();
        List<Product> list = productDAO.getAllProduct();
        CategoryDAO categoryDAO = new CategoryDAO();
        List<Category> listCate = categoryDAO.getAllCategory();
        request.setAttribute("categories", listCate);
        request.setAttribute("products", list);
        int total = productDAO.getTotal();
        request.setAttribute("total", total);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/AdminProduct.jsp");
        dispatcher.forward(request, response);
    }
    // view a product
    private void ViewProduct (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ProductDAO productDAO = new ProductDAO();
        Product product = productDAO.getProductById(id);
        request.setAttribute("product", product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/AdminDetailProduct.jsp");
        dispatcher.forward(request, response);
    }

    // delete a product
    private void Delete (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ProductDAO productDAO = new ProductDAO();
        productDAO.deleteProducts(id);
        ListProduct(request, response);
    }
    // Load product to Update
    private void LoadProductToUpDate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean checkCategory = false;
        int id = Integer.parseInt(request.getParameter("id"));
        CategoryDAO categoryDAO = new CategoryDAO();
        List<Category> categories = categoryDAO.getAllCategory();
        request.setAttribute("categories", categories);
        ProductDAO productDAO = new ProductDAO() ;
        Product product = productDAO.getProductById(id);
        request.setAttribute("product", product);
        for (Category category : categories
        ) {
            if (category.getName().equalsIgnoreCase(product.getCategory())){
                checkCategory = true;
                break;
            }
        }
        request.setAttribute("checkCategory", checkCategory);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/adminUpdateProduct.jsp");
        dispatcher.forward(request, response);

    }
    // Update product
    private void UpdateProduct (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String category = request.getParameter("category");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        String image = request.getParameter("image");

        Product product = new Product(id ,name, category , description , price , image);
        try {
            ProductDAO productDAO = new ProductDAO();
            productDAO.updateProduct(product);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        ListProduct(request, response);

    }

}
