package app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.model.Product;
import app.repository.ProductsRepository;


public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	ProductsRepository.addProducts();
    	super.init();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> products = ProductsRepository.getProductsAvailable();
		request.setAttribute("products", products);
		request.getRequestDispatcher("ui/jsp/user/products.jsp").forward(request, response);
		HttpSession session = request.getSession(true);
		session.setAttribute("currentpage", "products");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
