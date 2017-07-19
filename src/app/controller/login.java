package app.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import app.model.*;
import app.dataaccess.*;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
   
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	//super.init();
    	UsersData.addUsers();
    	
    } 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//check if there is an existing cookie
		String userName = null;
		//gets the link where this request has arrived from inorder to redirect it to that page
		String path = ( (HttpServletRequest) request).getRequestURI().substring(( (HttpServletRequest) request).getContextPath().length());
		System.out.println(request.getAttribute("message"));
		request.setAttribute("message", request.getAttribute("message"));
		System.out.println(request.getAttribute("message"));
		HttpSession session = request.getSession(true); 
		if( path.equalsIgnoreCase("/login.jsp")
	        		|| path.equalsIgnoreCase("/login")){
			path = "/";
		
		 }
		session.setAttribute("requestorpath", path);
		for (Cookie cookie : request.getCookies()) {
		    if (cookie.getName().equals("username")) {
		userName = cookie.getValue(); 
		break;}
		}
		if(userName != null) {
		request.setAttribute("uname", userName);
		request.setAttribute("rememberme", "checked");
		}
		request.getRequestDispatcher("ui/jsp/user/login.jsp").forward(request, response);
		
		//response.sendRedirect("login-form.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.println("Something is here today may be tomm there will be another");
		String username = request.getParameter("username").toString();
		String password = request.getParameter("password").toString();
		Boolean rememberme = request.getParameter("rememberme")!= null;
		//check if user exist and if password is pass 
		User loggedInUser = UsersData.checkUser(username, password);
		if(UsersData.hasLoggedIn()) {
			HttpSession session = request.getSession(true);
			session.setAttribute("CurrentUser", loggedInUser);
			if(rememberme) {
				//adding cookie
				Cookie cookie = new Cookie("username", loggedInUser.getUsername());
				cookie.setMaxAge(2592000);
				response.addCookie(cookie);
			}
			else {
				//removing cookie
				Cookie cookie = new Cookie("username", null);
				cookie.setMaxAge( -1);
				response.addCookie(cookie);
			}
			String requestorPath;

			
			//if the requestor didnt came from the login page go to home other wise to the one who requests  for normal users
			if(session.getAttribute("currentpage")!= null && loggedInUser.getRoles().stream().anyMatch(a -> a.getRole()=="user")) {
			  requestorPath = session.getAttribute("currentpage").toString();
			  response.sendRedirect(requestorPath);
				//request.getRequestDispatcher(requestorPath).forward(request, response);
				}
			else if(loggedInUser.getRoles().stream().anyMatch(a -> a.getRole()=="admin")) {
				//request.getRequestDispatcher("adminproducts").forward(request, response);
				response.sendRedirect("adminproducts");
			}
				
			
		}
		else {
			request.setAttribute("message", "Wrong username or password!!!");
			request.getRequestDispatcher("ui/jsp/user/login.jsp").forward(request, response);
			
			//response.sendRedirect("login");
		}
			
		
	}

}
