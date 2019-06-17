package cn.lut.hotelvip.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 字符过滤器
 */
public class CharacterFilter implements Filter {

	//局部变量，单单例对象的变量（线程安全问题）
	String charset="utf-8";
    public CharacterFilter() {
        // TODO Auto-generated constructor stub
    }
	public void destroy() {
		// TODO Auto-generated method stub
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		request.setCharacterEncoding(charset);
		response.setCharacterEncoding(charset);

		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {

		charset=fConfig.getInitParameter("charset");
		
		
	}

}
