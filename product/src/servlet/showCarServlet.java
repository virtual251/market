package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Car;
import bean.Order;
import bean.Product;
import bean.User;
import service.CarService;
import service.OrderService;
import service.ProductService;

public class showCarServlet extends BaseServlet{
	public void show(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		if(user==null){
			String[] values=null;
			Cookie[] cookie=request.getCookies();
			Map<Product,String> mp=new HashMap<Product,String>();
			for(Cookie c:cookie){
				if("productId".equals(c.getName())){
					values=c.getValue().split("_");
				}
			}
			if(values!=null){
			for(String id:values){
				ProductService ps=new ProductService();
				Product pro=ps.findBookById(id);
				mp.put(pro, "1");
			}
			request.setAttribute("car", mp);
			request.getRequestDispatcher("/car.jsp").forward(request, response);}else{
				System.out.println("购物车空的");
				request.setAttribute("message", "0");
				request.getRequestDispatcher("/car.jsp").forward(request, response);
			}
		}else{
		String userId=user.getId();
		CarService carservice=new CarService();
		Map<Product,String> mp=carservice.showCar(userId);
		if(mp.isEmpty()){
			System.out.println("购物车空的");
			request.setAttribute("message", "0");
			request.getRequestDispatcher("/car.jsp").forward(request, response);
		}else{
		request.setAttribute("car", mp);
		request.getRequestDispatcher("/car.jsp").forward(request, response);
		}
		}
	}	
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getParameter("kkkk");
	}
}
