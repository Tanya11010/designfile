package cn.lut.hotelvip.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 */
public class AuthorityFilter implements Filter {
	String SessionKey = "";
	String redirectURL = "";
	Set<String> notCheckURLSet = new HashSet<>();
    public AuthorityFilter() {
        // TODO Auto-generated constructor stub
    }

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httprequest = (HttpServletRequest) request;
		HttpServletResponse httpresponse = (HttpServletResponse) response;
		HttpSession session = httprequest.getSession();
		
		if(session.getAttribute("loginstate")!=null) {
			chain.doFilter(request, response);
			
		}else {
			String uri = httprequest.getRequestURI();
			String tempuri = uri.substring(httprequest.getContextPath().length());
		
			int pix = tempuri.lastIndexOf(".");
			String newtemppix = ".css";
			if (pix != -1) {
				newtemppix = tempuri.substring(pix);
			}
			if(notCheckURLSet.contains(tempuri) || notCheckURLSet.contains(newtemppix)) {
				chain.doFilter(request, response);
			}
			else {
			httpresponse.sendRedirect(httprequest.getContextPath()+redirectURL);
			}
			
		}
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		String notcheck = fConfig.getInitParameter("notcheckURLList");
		SessionKey = fConfig.getInitParameter("checkSessionKey");
		redirectURL = fConfig.getInitParameter("redirectURL");
		if (notcheck != null) {
			String[] params = notcheck.split(",");
			for (String strurl : params) {
				notCheckURLSet.add(strurl);
			}
		}
	}

}
