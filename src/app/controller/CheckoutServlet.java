package app.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.model.Checkout;
import app.model.ShoopingCart;

public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("checkout", buildCheckoutModel(request));
		request.getRequestDispatcher("/checkout.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	private Checkout buildCheckoutModel(HttpServletRequest request) {
		Checkout checkoutModel = new Checkout();
		List<ShoopingCart> checkoutProducts = (List<ShoopingCart>) request.getSession().getAttribute("session_products");
		checkoutModel.setCheckoutProducts(checkoutProducts);
		checkoutModel.setProductsQuantity(checkoutProducts.size());
		checkoutModel.setTotal(getTotal(checkoutProducts));
		return checkoutModel;
		
	}
	
	private double getTotal(List<ShoopingCart> products) {
		double value = 0.0;
		for (ShoopingCart product : products) {
			value = value + product.getProduct().getPrice();
		}
		return round(value, 2);
	}
	
	public static double round(double value, int places) {
	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}

}
