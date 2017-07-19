package app.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class checkloginfilter
 */
@WebFilter(
		
		filterName = "checkloginfilter",
		urlPatterns = "/login")
public class checkloginfilter implements Filter {

    /**
     * Default constructor. 
     */
    public checkloginfilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		String path = ( (HttpServletRequest) request).getRequestURI().substring(( (HttpServletRequest) request).getContextPath().length());
        if((( (HttpServletRequest) request).getSession().getAttribute("CurrentUser")!= null) 
        		|| path.equalsIgnoreCase("/") || path.equalsIgnoreCase("/login-form.jsp")
        		|| path.equalsIgnoreCase("/login")){
        	chain.doFilter(request, response);
        }
        else {
        ((HttpServletRequest)request).getRequestDispatcher("login.jsp").forward(request, response);
        }
		// pass the request along the filter chain
		//chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
