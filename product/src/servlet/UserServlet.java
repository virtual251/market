package servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import bean.Car;
import bean.Order;
import bean.User;
import exception.UserException;
import service.CarService;
import service.OrderService;
import service.UserService;

public class UserServlet extends BaseServlet {
	
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	String username=request.getParameter("username");
	String password=request.getParameter("password");
		UserService us = new UserService();
		try {
			String path="/myAccount.jsp";
			User user = us.login(username,password);
			Cookie[] cookies=request.getCookies();
			String[] productId=null;
			if(cookies!=null){
			for(Cookie i:cookies){
				if("productId".equals(i.getName())){
					productId=i.getValue().split("_");
				}
			}
			Cookie newcookie=new Cookie("productId",null);
			newcookie.setMaxAge(0);
			newcookie.setPath("/");
			response.addCookie(newcookie);
			String userId=user.getId();
			for(String s:productId){
			Car car=new Car();
			car.setUserId(userId);
			car.setProductId(s);
			CarService carservice=new CarService();
			try {
				carservice.addCar(car);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			}
			request.getSession().setAttribute("user", user);
			Cookie cookie=new Cookie("username",URLEncoder.encode(username,"utf-8"));
			response.addCookie(cookie);
			//request.getRequestDispatcher(path).forward(request, response);
			response.sendRedirect("/product/myAccount.jsp");
		} catch (UserException e) {
			e.printStackTrace();
			request.setAttribute("user_msg", e.getMessage());
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
	
	public void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//处理验证码
		String ckcode = request.getParameter("ckcode");
		String checkcode_session = (String) request.getSession().getAttribute("checkcode_session");
		if(!checkcode_session.equals(ckcode)){//如果两个验证码不一致，跳回注册面
			request.setAttribute("ckcode_msg", "验证码错误！");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return ;
		}
		//获取表单数据
		User user = new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());
			user.setActiveCode("666666");//手动设置激活码
			String id=user.getUsername()+user.getPassword();
			user.setId(id);
			Date d=new Date();
			user.setRegistTime(d);
			//调用业务逻辑
			UserService us = new UserService();
			us.regist(user);
			//分发转向
			//要求用户激活后才能登录，所以不能把用户信息保存session中
			//request.getSession().setAttribute("user", user);//把用户信息封装到session对象中
			request.getRequestDispatcher("/registersuccess.jsp").forward(request, response);
		}catch(UserException e){
			request.setAttribute("user_msg", e.getMessage());
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}
	public void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().invalidate();//使session销毁
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}
	
	
	public void findUserById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	/*	String id = request.getParameter("id");*/
		User user=(User) request.getSession().getAttribute("user");
		String id=user.getId();
		UserService us = new UserService();
		try {
			User w = us.findUserById(id);
			request.setAttribute("u", w);
			System.out.println(w);
			request.getRequestDispatcher("/modifyuserinfo.jsp").forward(request, response);
		} catch (UserException e) {
//			response.getWriter().write(e.getMessage());
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}
	}

}
