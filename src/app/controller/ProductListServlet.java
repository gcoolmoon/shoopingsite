package app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.repository.ProductsRepository;


public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	ProductsRepository.addProducts();
    	super.init();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("products", ProductsRepository.getProductsAvailable());
		request.getRequestDispatcher("ui/jsp/user/products.jsp").forward(request, response);
		HttpSession session = request.getSession(true);
		session.setAttribute("currentpage", "products");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
