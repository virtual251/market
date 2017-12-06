package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Product;
import bean.User;
import service.CarService;

public class ChangeNumServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String productid = request.getParameter("proId");
		int buyNum=Integer.parseInt(request.getParameter("num"));
		User u=(User) request.getSession().getAttribute("user");
		if(u!=null){
		String id=u.getId();
		CarService carservice=new CarService();
		carservice.changeNum(id,productid,buyNum);
		Map<Product,String> mp=(Map<Product, String>) request.getAttribute("car");
		PrintWriter out=response.getWriter();
		out.println(1);
	}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
