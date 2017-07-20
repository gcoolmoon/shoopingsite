package app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.dataaccess.UsersData;
import app.model.User;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		session.setAttribute("currentpage", "products");
		request.getRequestDispatcher("ui/jsp/user/registration.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		//get the information from the form
		String firstname = request.getParameter("firstname").toString();
		String lastname = request.getParameter("lastname").toString();
		String email = request.getParameter("email").toString();
		String password = request.getParameter("password").toString();
		
		//add user information 
		User user = new User() ;
		user.setEmail(email);
		user.setUsername(email);
		user.setFirstName(firstname);
		user.setLastName(lastname);
		user.setPassword(password);
		UsersData.add(user);
		
		//request.getRequestDispatcher("login").forward(request, response);
		response.sendRedirect("login");
	}

}
