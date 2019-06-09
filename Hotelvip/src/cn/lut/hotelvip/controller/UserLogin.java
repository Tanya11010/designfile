package cn.lut.hotelvip.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import cn.lut.hotelvip.domain.po.Administrator;
import cn.lut.hotelvip.domain.po.Customer;
import cn.lut.hotelvip.domain.vo.AdminVo;
import cn.lut.hotelvip.domain.vo.UserVo;
import cn.lut.hotelvip.service.UserService;
import cn.lut.hotelvip.service.impl.UserServiceImpl;
import cn.lut.hotelvip.utils.COMMON;

/**
 * 用户登录
 */
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       UserService userService = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//显示登录界面
		String token = COMMON.UUID();
		request.getSession().setAttribute("token", token);
		request.getRequestDispatcher("/WEB-INF/views/user/login.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//验证登录信息
		UserVo uv = COMMON.request2Bean(request, UserVo.class);
		AdminVo av = COMMON.request2Bean(request, AdminVo.class);
		String radio = request.getParameter("radio");
		//防止表单重复提交
		String sessiontocken = (String) request.getSession().getAttribute("token");
		if ((uv.getToken() == null|| av.getToken() == null) || sessiontocken == null ) {

			request.setAttribute("msg", "表单不能重复提交");
			request.getRequestDispatcher("/WEB-INF/views/user/login.jsp").forward(request, response);

			return;
		} else {

			if (uv.getToken().equals(sessiontocken)||av.getToken().equals(sessiontocken)) {
				request.getSession().removeAttribute("token");

			} else {
				request.setAttribute("msg", "表单不能重复提交");
				request.getRequestDispatcher("/WEB-INF/views/user/login.jsp").forward(request, response);
			}
		}
		//检查图形验证码
				HttpSession session = request.getSession();
				String sessionstr = (String) session.getAttribute("imgcodestr");
				if (sessionstr == null) {
					request.setAttribute("msg", "图片验证码不正确");
					request.getRequestDispatcher("/WEB-INF/views/user/login.jsp").forward(request, response);
					return;
				}
				if (sessionstr.equals(uv.getImagecode())||sessionstr.equals(av.getImagecode())) {
					// 验证用户名和密码
					Customer customer = new Customer();
					Administrator administrator = new Administrator();
					try {
						BeanUtils.copyProperties(customer, uv);
						BeanUtils.copyProperties(administrator, av);
					} catch (Exception e) {
					}
					customer = userService.loginCustomer(customer.getUsername(), customer.getUserpass());
					administrator = userService.loginAdministrator(administrator.getUsername(), administrator.getUserpass());
				
					//会员登录验证
					if (customer != null) {
						// 登录成功
						// 保留身份信息，权限验证中用来验证是否已登录过。
						session.setAttribute("loginstate", customer);
						if(radio.equals("userrad")) {
						request.getRequestDispatcher("/WEB-INF/views/usermain.jsp").forward(request, response);
						return;
						}else{
							request.setAttribute("msg", "用户名和密码错误");
							request.getRequestDispatcher("/WEB-INF/views/user/login.jsp").forward(request, response);
							return;
						}
						//管理员登录验证
					}else if(administrator!=null) {
						// 登录成功
						// 保留身份信息，权限验证中用来验证是否已登录过。
						session.setAttribute("loginstate", administrator);
						if(radio.equals("adminrad")) {
							request.getRequestDispatcher("/WEB-INF/views/adminmain.jsp").forward(request, response);
							return;
						}else{
							request.setAttribute("msg", "用户名和密码错误");
							request.getRequestDispatcher("/WEB-INF/views/user/login.jsp").forward(request, response);
							return;
						}
					} else {
						request.setAttribute("msg", "用户名和密码错误");
						request.getRequestDispatcher("/WEB-INF/views/user/login.jsp").forward(request, response);
						return;
					}

				} else {

					request.setAttribute("msg", "图片验证码不正确");
					request.getRequestDispatcher("/WEB-INF/views/user/login.jsp").forward(request, response);
					return;
				}

			}
	}


