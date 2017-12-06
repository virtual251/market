package servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import bean.User;
import service.CarService;

public class deleteCarServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException{
		String productId=request.getParameter("id");
		User u=(User) request.getSession().getAttribute("user");
		if(u!=null){
		String id=u.getId();
		CarService carservice=new CarService();
		carservice.deleteCar(id, productId);
		try {
			Map<Product,String> mp=carservice.showCar(id);
			request.setAttribute("car", mp);
			request.getRequestDispatcher("/car.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else{
			
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException{
		doGet(request,response);
	}

}
