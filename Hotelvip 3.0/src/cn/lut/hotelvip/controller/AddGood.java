package cn.lut.hotelvip.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.lut.hotelvip.domain.po.Good;
import cn.lut.hotelvip.service.AdminService;
import cn.lut.hotelvip.service.impl.AdminServiceImpl;

/**
 * Servlet implementation class AddGood
 */
public class AddGood extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminService  as = new AdminServiceImpl();      
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/addGood.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		Good good = new Good();
		good.setGoodid(request.getParameter("goodid"));
		good.setGoodname(request.getParameter("goodname"));
		good.setGoodprice(Double.valueOf(request.getParameter("goodprice")));
		good.setGoodnum(Integer.parseInt(request.getParameter("goodnum")));
		
		boolean res = as.addGood(good);
		PrintWriter out = response.getWriter();
		if(res) {
			response.sendRedirect(request.getContextPath() + "/adminservlet?type=showgood");
		}else {
			out.print("<script>alert('添加失败!');</script>");
			request.getRequestDispatcher("/addGood.jsp").forward(request, response);
		}
	}

}
