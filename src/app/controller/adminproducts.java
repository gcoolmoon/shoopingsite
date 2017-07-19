package app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.model.Product;
import app.repository.ProductsRepository;

/**
 * Servlet implementation class adminproducts
 */
@WebServlet("/adminproducts")
public class adminproducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminproducts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("ui/jsp/admin/admin_products.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		int productId = -1;
		//get parameter values from admin products page 
		String crudAction = request.getParameter("crudaction");
		if("add".equals(crudAction)) {
		if(!request.getParameter("productid").isEmpty())
		   productId = Integer.parseInt(request.getParameter("productid")) ;
		else
			productId =(int )(Math. random() * 500 + 1) ; // only for 500 products
		String productName = request.getParameter("productname");
		Double price = Double.parseDouble(request.getParameter("price")) ;
		int amount = Integer.parseInt(request.getParameter("amount")) ;
		String imagePath = request.getParameter("path");
		String description = request.getParameter("productdesc");
		
		
		// now pass the values to product object 
		
		Product product = new Product();
		product.setAmountAvailable(amount);
		product.setImage(imagePath);
		product.setPrice(price);
		product.setProductDescription(description);
		//if(productId != -1)
		product.setProductId(productId);
		//doGet(request, response);
		
		//add products 
		ProductsRepository.addProduct(product);
		response.sendRedirect("adminproducts");
		}
		else if("update".equals(crudAction))
		{
			productId = Integer.parseInt(request.getParameter("productid")) ;
			int additionalamount = Integer.parseInt(request.getParameter("amount")) ;
			
			//get a product by id and then update the amount and save it back
			ProductsRepository.updateProduct(productId, additionalamount);
			response.sendRedirect("inventory");
		}
		
		// send to the model class to update the data access 
		
		//redirect back to the add products page
		
		
		
		
	}
}
