package service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import bean.Car;
import bean.Product;
import dao.CarDao;

public class CarService {
	public void addCar(Car car) throws SQLException{
		isExit(car);
	}
	public void isExit(Car car) throws SQLException{
		String productId=car.getProductId();
		String userId=car.getUserId();
		CarDao cardao=new CarDao();
		cardao.isExitProduct(userId,productId);
	}
	public Map<Product,String> showCar(String userId){
		CarDao cardao=new CarDao();
		try {
			List<Car> li=cardao.showCar(userId);
			ProductService bs = new ProductService();
			Map<Product,String> mp=new HashMap<Product,String>();
			
			for(Car i:li){
				Product goods=bs.findBookById(i.getProductId());
				mp.put(goods,String.valueOf(i.getBuyNum()));
			} 
			return mp;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public List<Car> showCarByBoth(String userId,String productId){
		CarDao cardao=new CarDao();
		try {
			return cardao.showCarByBoth(userId, productId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public void changeNum(String userId,String productId,int buyNum){
		CarDao cardao=new CarDao();
		try {
			cardao.addNum(buyNum, userId, productId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteCar(String userId,String productId){
		CarDao cardao=new CarDao();
		try {
			cardao.deleteCar(userId, productId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
