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
 * Servlet implementation class OutRoom
 */
public class OutRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminService  as = new AdminServiceImpl(); 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/outroom.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String roomId = request.getParameter("roomid");
		boolean res = as.outRoom(roomId);
		PrintWriter out = response.getWriter();
		if(res) {
			out.print("<script>alert('退房成功!');</script>");
		}else {
			request.getRequestDispatcher("/outroom.jsp").forward(request, response);
		}
	}

}
