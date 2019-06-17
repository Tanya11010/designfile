package cn.lut.hotelvip.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.lut.hotelvip.service.AdminService;
import cn.lut.hotelvip.service.impl.AdminServiceImpl;

/**
 * Servlet implementation class AddMoney
 */
public class AddMoney extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminService  as = new AdminServiceImpl();
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/addMoney.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userId = request.getParameter("userid");
		double addMoney = Double.valueOf(request.getParameter("addmoney"));
		PrintWriter out = response.getWriter();
		boolean res = as.addMoney(userId, addMoney);
		if(res) {
			out.print("<script>alert('充值成功!');</script>");
			
		}else {
			out.print("<script>alert('充值失败!');</script>");
			
		}
	}

}
