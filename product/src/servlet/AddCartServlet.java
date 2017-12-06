package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Car;
import bean.Order;
import bean.Product;
import bean.User;
import service.CarService;
import service.OrderService;
import service.ProductService;

public class AddCartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String productId=request.getParameter("id");
		if(request.getSession().getAttribute("user")==null){
			Cookie[] cookie=request.getCookies();
			int state=0;
			for(Cookie c:cookie){
				if("productId".equals(c.getName())){
					String newProductId=c.getValue()+"_"+productId;
					Cookie cookieforproduct=new Cookie("productId", newProductId);
					cookieforproduct.setMaxAge(3600*24);
					response.addCookie(cookieforproduct);
					state=1;
					break;
					//String[] values=c.getValue().split(";");
				}
			}
			if(state==0){
					Cookie cookieforproduct=new Cookie("productId", productId);
					cookieforproduct.setMaxAge(3600*24);
					response.addCookie(cookieforproduct);
			}
			request.getRequestDispatcher("/addCarSuccess.jsp").forward(request, response);
		}else{
		User user=(User) request.getSession().getAttribute("user");
		String userId=user.getId();
		Car car=new Car();
		car.setUserId(userId);
		car.setProductId(productId);
		CarService carservice=new CarService();
		try {
			carservice.addCar(car);
			request.getRequestDispatcher("/addCarSuccess.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.setContentType("text/html;charset=UTF-8");}
		
	
		
		/*PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		
		ProductService bs = new ProductService();
		
		Product b = bs.findBookById(id);
		
		//从session中的购物车取出 来
		HttpSession session = request.getSession();
		Map<Product, String> cart = (Map<Product, String>) session.getAttribute("cart");
		int num = 1;
		//如何是第一次访问，没有购物车对象，我们就创建 一个购物车对象
		if(cart==null){
			cart = new HashMap<Product, String>();
			
		}
		//查看当前集合中是否存在b这本书,如果有就把数据取出来加1;
		if(cart.containsKey(b)){
			num=Integer.parseInt(cart.get(b))+1;
		}
		//把图书放入购物车
		cart.put(b, num+"");
		
		//把cart对象放回到session作用域中
		session.setAttribute("cart", cart);
		
		out.print("<a href='"+request.getContextPath()+"/pageServlet'>继续购物</a>，<a href='"+request.getContextPath()+"/cart.jsp'>查看购物车</a>");*/
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
