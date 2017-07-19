package app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.repository.ProductsRepository;


public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("products", ProductsRepository.getProductsAvailable());
		request.getRequestDispatcher("ui/jsp/user/products.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
