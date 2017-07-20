package app.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import app.model.Product;
import app.model.ShoopingCart;
import app.repository.ProductsRepository;

public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ObjectMapper mapper = new ObjectMapper();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String productParam = request.getParameter("product");
		if (productParam != null) {
			Product product = ProductsRepository.getProduct(Integer.valueOf(productParam));
			PrintWriter out = response.getWriter();
			try {
				out.print(mapper.writeValueAsString(product));
			} catch (JsonGenerationException e) {
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String checkoutProduct = request.getParameter("checkout_products");
		List<ShoopingCart> shoppingProduct = mapper.readValue(checkoutProduct, new TypeReference<List<ShoopingCart>>(){});
		updateSessionProducts(request, shoppingProduct);
	}

	private void updateSessionProducts(HttpServletRequest request, List<ShoopingCart> shoppingProducts) {
		request.getSession().setAttribute("session_products", shoppingProducts);
	}

}
