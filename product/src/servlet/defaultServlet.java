package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Car;
import bean.User;
import service.CarService;

public class defaultServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException{
		Cookie[] cookies=request.getCookies();
		User user=(User) request.getSession().getAttribute("user");
		String[] proId=null;
		Cookie[] cookie=request.getCookies();
		for(Cookie c:cookie){
			if("productId".equals(c.getName())){
				proId=c.getValue().split("_");
			}
		}
		if(user!=null){
		for(String p:proId){
		String userId=user.getId();
		Car car=new Car();
		car.setUserId(userId);
		car.setProductId(p);
		CarService carservice=new CarService();
		try {
			carservice.addCar(car);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
}
}
