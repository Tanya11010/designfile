package cn.lut.hotelvip.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.lut.hotelvip.domain.po.Customer;
import cn.lut.hotelvip.service.AdminService;
import cn.lut.hotelvip.service.impl.AdminServiceImpl;

/**
 * Servlet implementation class SelectUser
 */
public class SelectUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminService  as = new AdminServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/select.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		Customer cus = new Customer();
		cus = as.selectUser(request.getParameter("id"), request.getParameter("name"));
		request.setAttribute("cust", cus);
		if(cus!=null) {
			request.getRequestDispatcher("/userbyid.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/select.jsp").forward(request, response);
		}
	}

}
