package cn.lut.hotelvip.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.lut.hotelvip.domain.po.Cost;
import cn.lut.hotelvip.domain.po.Good;
import cn.lut.hotelvip.service.UserService;
import cn.lut.hotelvip.service.impl.UserServiceImpl;


/**
 * 消费记录
 */
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService us = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String oper = request.getParameter("type");
		if ("query".equals(oper)) {
			QueryCost(request, response);
		} else if ("querygood".equals(oper)) {
			QueryGood(request, response);
		} else if ("delete".equals(oper)) {
			deleteCost(request, response);
		} else if ("exchange".equals(oper)) {
			exchangeGood(request, response);
		} 

	}

	// 显示消费列表
	public void QueryCost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		long sqlrowcount = us.getCostCount(); // 总的数据库条数
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
		List<Cost> listcustom = us.showList(pageindex, pagesize);

		request.setAttribute("pageindex", pageindex);// 页码
		request.setAttribute("pagesize", pagesize);// 页的显示条数
		request.setAttribute("pagecount", pagecount);// 页的总的张数
		request.setAttribute("curpageindex", curpageindex);// 当前页码
		request.setAttribute("listcustom", listcustom);

		request.getRequestDispatcher("/right.jsp").forward(request, response);

	}

	// 显示商品列表
	public void QueryGood(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		long sqlrowcount = us.getGoodCount(); // 总的数据库条数
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
		List<Good> listcustom = us.showGoodList(pageindex, pagesize);
		
		request.setAttribute("pageindex", pageindex);// 页码
		request.setAttribute("pagesize", pagesize);// 页的显示条数
		request.setAttribute("pagecount", pagecount);// 页的总的张数
		request.setAttribute("curpageindex", curpageindex);// 当前页码
		request.setAttribute("listcustom", listcustom);

		request.getRequestDispatcher("/good.jsp").forward(request, response);
	}

	// 删除消费记录
	public void deleteCost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		String oper = request.getParameter("id");
		boolean result = us.deleteRecord(oper);
		if (result) {

			request.getRequestDispatcher("/customerservlet?type=query").forward(request, response);

		} else {
			//删除不成功
			PrintWriter out=response.getWriter();
			out.print("<script>alert(\"抱歉，没能删除\");</script>"); 
			request.getRequestDispatcher("/customerservlet?type=query").forward(request, response);
		}
	}
	//积分兑换
	public void exchangeGood(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		String custid = request.getParameter("custid");
		String goodid = request.getParameter("goodid");
		boolean result = us.exchangeGood(goodid, custid);
		if(result) {
			request.getRequestDispatcher("/customerservlet?type=querygood").forward(request, response);
			return;
		}else {
			PrintWriter out=response.getWriter();
			out.print("<script>alert(\"抱歉，兑换失败\");</script>"); 
			request.getRequestDispatcher("/customerservlet?type=querygood").forward(request, response);
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
