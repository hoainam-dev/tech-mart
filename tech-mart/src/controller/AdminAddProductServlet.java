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

@WebServlet(name = "AdminAddProductServlet", value = "/add")
public class AdminAddProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryDAO categoryDAO = new CategoryDAO();
        List<Category> categories = categoryDAO.getAllCategory();
        request.setAttribute("categories", categories);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/adminAddProduct.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String category = request.getParameter("category");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        String image = request.getParameter("image");
        // nếu không thì tiếp tục
        Product product = new Product(id ,name, category , description , price , image);

        try {
            boolean Status ;
            if (!checkID(id) ){
                ProductDAO productDAO = new ProductDAO();
                productDAO.addProduct(product);
                String contextPath = request.getContextPath();
                response.sendRedirect(contextPath +"/product");
            } else if (checkID(id) ){
                Status = true;
                request.setAttribute("Status", Status);
                CategoryDAO categoryDAO = new CategoryDAO();
                List<Category> categories = categoryDAO.getAllCategory();
                request.setAttribute("categories", categories);
                RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/adminAddProduct.jsp");
                dispatcher.forward(request, response);
            }


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    // check IDProduct đã tồn tại chưa
    protected boolean checkID(int idParam) {
        ProductDAO productDAO = new ProductDAO();
        List<Product> products = productDAO.getAllProduct();
        // kiểm tra Id đã tồn tại hay chưa
        boolean Status = false;
        for (Product product1: products
        ) {
            if(idParam != product1.getId()) {
                Status = false;

            } else {
                Status = true;
                break;
            }
        }
        return Status;
    }

}
