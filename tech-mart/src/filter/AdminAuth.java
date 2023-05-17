package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 
 * @author Namhh
 * Class filter for admin url
 */
public class AdminAuth implements Filter {

    
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
        
        HttpSession s = req.getSession();
        String email = null;
        if(s.getAttribute("sessuser")==null) {
        	request.setAttribute("msg", "Please Login to access this page!");
			request.getRequestDispatcher("/views/auth/login.jsp").forward(request, response);
        }
        else {
        	email = s.getAttribute("sessuser").toString();
        	if(email.equals("admin@gmail.com")) {
        		// Allow the request to continue
        		chain.doFilter(request, response);
        	}
        else {
        	// Redirect to login page
        	request.setAttribute("msg", "You do not have permission to access this page! Try another account");
			request.getRequestDispatcher("/views/auth/login.jsp").forward(request, response);
        }
        }
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
