package controller;

import dao.CategoryDAO;
import dao.FilterProductDao;
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

@WebServlet(name = "AdminFilterProductServlet", value = "/filter")
public class AdminFilterProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String selectedCategory = request.getParameter("category");
        String selectedPrice = request.getParameter("price");
        FilterProductDao filterProductDao = new FilterProductDao();
        List<Product> list = filterProductDao.getProductByPriceAndCate(selectedCategory , selectedPrice);
        request.setAttribute("products", list);
        CategoryDAO categoryDAO = new CategoryDAO();
        List<Category> categories = categoryDAO.getAllCategory();
        request.setAttribute("categories" , categories);
        int total = list.size();
        request.setAttribute("total", total);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/AdminFilter.jsp");
        dispatcher.forward(request, response);
    }
}
