package cn.lut.hotelvip.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.lut.hotelvip.domain.po.Customer;
import cn.lut.hotelvip.service.AdminService;
import cn.lut.hotelvip.service.impl.AdminServiceImpl;

/**
 * Servlet implementation class InRoom
 */
public class InRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminService  as = new AdminServiceImpl();   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/inroom.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Customer cus = new Customer();
		//时间
		Date date;
		Timestamp date1=null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(request.getParameter("time"));
			date1=new Timestamp(date.getTime());//把java.util.Date类型转换为java.sql.Timestamp
		} catch (ParseException e) {
			e.printStackTrace();
		}//获取系统时间
	
		
		cus.setUserid(request.getParameter("userid"));
		cus.setUsername(request.getParameter("name"));
		cus.setUseridcard(request.getParameter("useridcard"));
		cus.setUsermoney(Double.valueOf(request.getParameter("usermoney")));
		cus.setUsergrade(Integer.parseInt(request.getParameter("usergrade")));
		String roomId = request.getParameter("roomid");
		
		boolean res01 = as.inRoom(cus, roomId);
		PrintWriter out = response.getWriter();
		if(res01) {
			as.insertRecord(cus,date1);
			out.print("<script>alert('入住成功!');</script>");
		}else {
			request.getRequestDispatcher("/inroom.jsp").forward(request, response);
		}
	}
}
