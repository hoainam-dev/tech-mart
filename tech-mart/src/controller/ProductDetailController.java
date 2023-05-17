package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import model.Product;


public class ProductDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductDAO productDAO = new ProductDAO();
		
		String id = request.getParameter("id");
		
		if(id!=null) {
			for (Product product : productDAO.getAllProduct()) {
				if(Integer.parseInt(id)==product.getId()){
					request.setAttribute("product", product);
				}
			}
		}
		request.getRequestDispatcher("/views/client/product/detail-product.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
