package app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import app.model.Product;
import app.repository.ProductsRepository;


import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ProductDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static ObjectMapper mapper = new ObjectMapper();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product product = ProductsRepository.getProduct(Integer.valueOf(request.getParameter("productId")));
		request.setAttribute("product", product);
		request.getRequestDispatcher("ui/jsp/user/product_detail.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Product product = new Product();
		int id= Integer.parseInt( request.getParameter("id"));
		product = ProductsRepository.getProduct(id);
		PrintWriter out =response.getWriter();
		try{
			out.print(mapper.writeValueAsString(product));
		}catch (JsonGenerationException e) {
			e.printStackTrace();
		}
	
	
	}

}
