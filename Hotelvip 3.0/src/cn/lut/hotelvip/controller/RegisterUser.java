package cn.lut.hotelvip.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.lut.hotelvip.domain.po.Customer;
import cn.lut.hotelvip.service.AdminService;
import cn.lut.hotelvip.service.impl.AdminServiceImpl;

/**
 * Servlet implementation class RegisterUser
 */
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminService  as = new AdminServiceImpl();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/register.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		Customer cus = new Customer();
		cus.setUserid(request.getParameter("id"));
		cus.setUsername(request.getParameter("name"));
		cus.setUserpass(request.getParameter("password"));
	    cus.setUsersex(request.getParameter("sex"));
		cus.setUseridcard(request.getParameter("idcard"));
		cus.setUsertel(request.getParameter("tel"));
		cus.setReuserpass(request.getParameter("repassword"));
		cus.setOpendate(Date.valueOf(request.getParameter("time")));
		boolean res = as.resgisteruser(cus);
		PrintWriter out = response.getWriter();
		if(res) {
			out.print("<script>alert('×¢²á³É¹¦!');</script>");
		}else {
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
		
	}

}
