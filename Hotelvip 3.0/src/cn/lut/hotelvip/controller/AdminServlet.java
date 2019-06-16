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
 * ����Ա����
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

	// ��ʾ������Ϣ
	public void QueryRoom(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		long sqlrowcount = as.getRoomCount(); // �ܵ����ݿ�����

		// ��������ʹ�ù������������ַ�����
		response.setContentType("text/html;characterset='utf-8'");
		response.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();

		// ����ҳ��
		int pageindex = 1; // ҳ��
		int pagesize = 18; // ҳ����ʾ����
		int pagecount = 1; // ҳ���ܵ�����
		int curpageindex = 1; // ��ǰҳ��

		String pageobj = request.getParameter("pageindex");

		if (pageobj != null) {
			try {
				pageindex = Integer.parseInt(pageobj);
			} catch (Exception e) {
				pageindex = 1;
			}
		}
		// �ж�pageindex����Ч��
		if (pageindex <= 0)
			pageindex = 1;
		// �ж�pageindex�Ƿ������ҳ������������%ҳ�Ĵ�С==0��������/ҳ�Ĵ�С : (������/ҳ�Ĵ�С)+1��
		pagecount = (int) (sqlrowcount % pagesize == 0 ? sqlrowcount / pagesize : (sqlrowcount / pagesize) + 1);

		if (pageindex >= pagecount) {
			pageindex = pagecount;
		}
		curpageindex = pageindex;
		List<Room> listcustom = as.showRoom(pageindex, pagesize);

		request.setAttribute("pageindex", pageindex);// ҳ��
		request.setAttribute("pagesize", pagesize);// ҳ����ʾ����
		request.setAttribute("pagecount", pagecount);// ҳ���ܵ�����
		request.setAttribute("curpageindex", curpageindex);// ��ǰҳ��
		request.setAttribute("listcustom", listcustom);

		request.getRequestDispatcher("/room.jsp").forward(request, response);
	}

	// ��ʾ��Ʒ�б�
	public void QueryGood(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		long sqlrowcount = as.getGoodCount(); // �ܵ����ݿ�����

		// ��������ʹ�ù������������ַ�����
		response.setContentType("text/html;characterset='utf-8'");
		response.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();

		// ����ҳ��
		int pageindex = 1; // ҳ��
		int pagesize = 15; // ҳ����ʾ����
		int pagecount = 1; // ҳ���ܵ�����
		int curpageindex = 1; // ��ǰҳ��

		String pageobj = request.getParameter("pageindex");

		if (pageobj != null) {
			try {
				pageindex = Integer.parseInt(pageobj);
			} catch (Exception e) {
				pageindex = 1;
			}
		}
		// �ж�pageindex����Ч��
		if (pageindex <= 0)
			pageindex = 1;
		// �ж�pageindex�Ƿ������ҳ������������%ҳ�Ĵ�С==0��������/ҳ�Ĵ�С : (������/ҳ�Ĵ�С)+1��
		pagecount = (int) (sqlrowcount % pagesize == 0 ? sqlrowcount / pagesize : (sqlrowcount / pagesize) + 1);

		if (pageindex >= pagecount) {
			pageindex = pagecount;
		}
		curpageindex = pageindex;
		List<Good> listcustom = as.showGood(curpageindex, pagesize);

		request.setAttribute("pageindex", pageindex);// ҳ��
		request.setAttribute("pagesize", pagesize);// ҳ����ʾ����
		request.setAttribute("pagecount", pagecount);// ҳ���ܵ�����
		request.setAttribute("curpageindex", curpageindex);// ��ǰҳ��
		request.setAttribute("listcustom", listcustom);

		request.getRequestDispatcher("/showgood.jsp").forward(request, response);
	}

	// ��ѯ��Ա��Ϣ
	public void QueryUser(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		long sqlrowcount = as.getCustomerCount(); // �ܵ����ݿ�����

		// ��������ʹ�ù������������ַ�����
		response.setContentType("text/html;characterset='utf-8'");
		response.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();

		// ����ҳ��
		int pageindex = 1; // ҳ��
		int pagesize = 18; // ҳ����ʾ����
		int pagecount = 1; // ҳ���ܵ�����
		int curpageindex = 1; // ��ǰҳ��

		String pageobj = request.getParameter("pageindex");

		if (pageobj != null) {
			try {
				pageindex = Integer.parseInt(pageobj);
			} catch (Exception e) {
				pageindex = 1;
			}
		}
		// �ж�pageindex����Ч��
		if (pageindex <= 0)
			pageindex = 1;
		// �ж�pageindex�Ƿ������ҳ������������%ҳ�Ĵ�С==0��������/ҳ�Ĵ�С : (������/ҳ�Ĵ�С)+1��
		pagecount = (int) (sqlrowcount % pagesize == 0 ? sqlrowcount / pagesize : (sqlrowcount / pagesize) + 1);

		if (pageindex >= pagecount) {
			pageindex = pagecount;
		}
		curpageindex = pageindex;
		List<Customer> listcustom = as.showCustomer(curpageindex, pagesize);

		request.setAttribute("pageindex", pageindex);// ҳ��
		request.setAttribute("pagesize", pagesize);// ҳ����ʾ����
		request.setAttribute("pagecount", pagecount);// ҳ���ܵ�����
		request.setAttribute("curpageindex", curpageindex);// ��ǰҳ��
		request.setAttribute("listcustom", listcustom);

		request.getRequestDispatcher("/user.jsp").forward(request, response);
	}
	//ɾ����Ʒ
	public void DeleteGood(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		String goodId = request.getParameter("goodid");
		boolean result = as.deleteGood(goodId);
		if (result) {

			request.getRequestDispatcher("/adminservlet?type=showgood").forward(request, response);

		} else {
			//ɾ�����ɹ�
			PrintWriter out=response.getWriter();
			out.print("<script>alert(\"��Ǹ��û��ɾ��\");</script>"); 
			
		}
		
	}
	//ɾ����Ա
	public void DeleteUser(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		String userId = request.getParameter("userid");
		
		boolean result = as.deleteCustomer(userId);
		if (result) {

			request.getRequestDispatcher("/adminservlet?type=showuser").forward(request, response);

		} else {
			//ɾ�����ɹ�
			PrintWriter out=response.getWriter();
			out.print("<script>alert(\"��Ǹ��û��ɾ��\");</script>"); 
			request.getRequestDispatcher("/adminservlet?type=showuser").forward(request, response);
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
