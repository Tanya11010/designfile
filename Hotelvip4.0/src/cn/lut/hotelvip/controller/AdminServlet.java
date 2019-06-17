package cn.lut.hotelvip.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.lut.hotelvip.domain.po.Customer;
import cn.lut.hotelvip.domain.po.Good;
import cn.lut.hotelvip.domain.po.Room;
import cn.lut.hotelvip.service.AdminService;
import cn.lut.hotelvip.service.impl.AdminServiceImpl;

/**
 * 管理员界面
 */
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminService as = new AdminServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String oper = request.getParameter("type");
		if ("queryroom".equals(oper)) {
			QueryRoom(request, response);
		} else if ("showgood".equals(oper)) {
			QueryGood(request, response);
		} else if ("deletegood".equals(oper)) {
			DeleteGood(request, response);
		} else if ("deleteuser".equals(oper)) {
			DeleteUser(request, response);
		}else if ("showuser".equals(oper)) {
			QueryUser(request, response);
		} else if ("register".equals(oper)) {
			response.sendRedirect(request.getContextPath() + "/registeruser");
		} else if ("addgood".equals(oper)) {
			response.sendRedirect(request.getContextPath() + "/addgood");
		} else if ("select".equals(oper)) {
			response.sendRedirect(request.getContextPath() + "/selectuser");
		}else if ("inroom".equals(oper)) {
			response.sendRedirect(request.getContextPath() + "/inroom");
		}else if ("outroom".equals(oper)) {
			response.sendRedirect(request.getContextPath() + "/outroom");
		}else if ("addmoney".equals(oper)) {
			response.sendRedirect(request.getContextPath() + "/addmoney");
		}
	}

	// 显示房间信息
	public void QueryRoom(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		long sqlrowcount = as.getRoomCount(); // 总的数据库条数

		// 明天我们使用过滤器来做。字符设置
		response.setContentType("text/html;characterset='utf-8'");
		response.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();

		// 控制页码
		int pageindex = 1; // 页码
		int pagesize = 18; // 页的显示条数
		int pagecount = 1; // 页的总的张数
		int curpageindex = 1; // 当前页码

		String pageobj = request.getParameter("pageindex");

		if (pageobj != null) {
			try {
				pageindex = Integer.parseInt(pageobj);
			} catch (Exception e) {
				pageindex = 1;
			}
		}
		// 判断pageindex的有效性
		if (pageindex <= 0)
			pageindex = 1;
		// 判断pageindex是否大于总页数：（总条数%页的大小==0？总条数/页的大小 : (总条数/页的大小)+1）
		pagecount = (int) (sqlrowcount % pagesize == 0 ? sqlrowcount / pagesize : (sqlrowcount / pagesize) + 1);

		if (pageindex >= pagecount) {
			pageindex = pagecount;
		}
		curpageindex = pageindex;
		List<Room> listcustom = as.showRoom(pageindex, pagesize);

		request.setAttribute("pageindex", pageindex);// 页码
		request.setAttribute("pagesize", pagesize);// 页的显示条数
		request.setAttribute("pagecount", pagecount);// 页的总的张数
		request.setAttribute("curpageindex", curpageindex);// 当前页码
		request.setAttribute("listcustom", listcustom);

		request.getRequestDispatcher("/room.jsp").forward(request, response);
	}

	// 显示商品列表
	public void QueryGood(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		long sqlrowcount = as.getGoodCount(); // 总的数据库条数

		// 明天我们使用过滤器来做。字符设置
		response.setContentType("text/html;characterset='utf-8'");
		response.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();

		// 控制页码
		int pageindex = 1; // 页码
		int pagesize = 15; // 页的显示条数
		int pagecount = 1; // 页的总的张数
		int curpageindex = 1; // 当前页码

		String pageobj = request.getParameter("pageindex");

		if (pageobj != null) {
			try {
				pageindex = Integer.parseInt(pageobj);
			} catch (Exception e) {
				pageindex = 1;
			}
		}
		// 判断pageindex的有效性
		if (pageindex <= 0)
			pageindex = 1;
		// 判断pageindex是否大于总页数：（总条数%页的大小==0？总条数/页的大小 : (总条数/页的大小)+1）
		pagecount = (int) (sqlrowcount % pagesize == 0 ? sqlrowcount / pagesize : (sqlrowcount / pagesize) + 1);

		if (pageindex >= pagecount) {
			pageindex = pagecount;
		}
		curpageindex = pageindex;
		List<Good> listcustom = as.showGood(curpageindex, pagesize);

		request.setAttribute("pageindex", pageindex);// 页码
		request.setAttribute("pagesize", pagesize);// 页的显示条数
		request.setAttribute("pagecount", pagecount);// 页的总的张数
		request.setAttribute("curpageindex", curpageindex);// 当前页码
		request.setAttribute("listcustom", listcustom);

		request.getRequestDispatcher("/showgood.jsp").forward(request, response);
	}

	// 查询会员信息
	public void QueryUser(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		long sqlrowcount = as.getCustomerCount(); // 总的数据库条数

		// 明天我们使用过滤器来做。字符设置
		response.setContentType("text/html;characterset='utf-8'");
		response.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();

		// 控制页码
		int pageindex = 1; // 页码
		int pagesize = 18; // 页的显示条数
		int pagecount = 1; // 页的总的张数
		int curpageindex = 1; // 当前页码

		String pageobj = request.getParameter("pageindex");

		if (pageobj != null) {
			try {
				pageindex = Integer.parseInt(pageobj);
			} catch (Exception e) {
				pageindex = 1;
			}
		}
		// 判断pageindex的有效性
		if (pageindex <= 0)
			pageindex = 1;
		// 判断pageindex是否大于总页数：（总条数%页的大小==0？总条数/页的大小 : (总条数/页的大小)+1）
		pagecount = (int) (sqlrowcount % pagesize == 0 ? sqlrowcount / pagesize : (sqlrowcount / pagesize) + 1);

		if (pageindex >= pagecount) {
			pageindex = pagecount;
		}
		curpageindex = pageindex;
		List<Customer> listcustom = as.showCustomer(curpageindex, pagesize);

		request.setAttribute("pageindex", pageindex);// 页码
		request.setAttribute("pagesize", pagesize);// 页的显示条数
		request.setAttribute("pagecount", pagecount);// 页的总的张数
		request.setAttribute("curpageindex", curpageindex);// 当前页码
		request.setAttribute("listcustom", listcustom);

		request.getRequestDispatcher("/user.jsp").forward(request, response);
	}
	//删除商品
	public void DeleteGood(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		String goodId = request.getParameter("goodid");
		boolean result = as.deleteGood(goodId);
		if (result) {

			request.getRequestDispatcher("/adminservlet?type=showgood").forward(request, response);

		} else {
			//删除不成功
			PrintWriter out=response.getWriter();
			out.print("<script>alert(\"抱歉，没能删除\");</script>"); 
			
		}
		
	}
	//删除会员
	public void DeleteUser(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		String userId = request.getParameter("userid");
		
		boolean result = as.deleteCustomer(userId);
		if (result) {

			request.getRequestDispatcher("/adminservlet?type=showuser").forward(request, response);

		} else {
			//删除不成功
			PrintWriter out=response.getWriter();
			out.print("<script>alert(\"抱歉，没能删除\");</script>"); 
			request.getRequestDispatcher("/adminservlet?type=showuser").forward(request, response);
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
