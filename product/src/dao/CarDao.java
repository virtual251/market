package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import bean.Car;
import util.C3P0Util;

public class CarDao {
public void isExitProduct(String userId,String productId) throws SQLException{
	QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
	String sql="select * from car where userId=? and productId=?";
	List<Car> ob=qr.query(sql,new BeanListHandler<Car>(Car.class),userId,productId);
	System.out.println(userId+productId);
	System.out.println(ob);
	if(ob.size()!=0){
		System.out.println("该物品已经加入了购物车，数量加一就可以了");
		int buyNum=ob.get(0).getBuyNum();
		buyNum++;
		addNum(buyNum,userId,productId);
	}else{
		System.out.println("该物品没有加入购物车，要重新建立");
		addCar(userId,productId);
	}
}
public void addNum(int buyNum,String userId,String productId) throws SQLException{
	QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
	String sql="update car set buyNum=? where userId=? and productId=?";
	qr.update(sql,buyNum,userId,productId);
}
public void addCar(String userId,String productId) throws SQLException{
	QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
	String sql="insert into car value(?,?,?)";
	qr.update(sql,userId,productId,1);
}
public void deleteCar(String userId,String productId) throws SQLException{
	QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
	String sql="delete from car where userId=? and productId=?";
	qr.update(sql,userId,productId);
}
public List<Car> showCar(String userId) throws SQLException{
	QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
	String sql="select * from car where userId=?";
	List<Car> li=qr.query(sql,new BeanListHandler<Car>(Car.class), userId);
	return li;
}
public List<Car> showCarByBoth(String userId,String productId) throws SQLException{
	QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
	String sql="select * from car where userId=? and productId=?";
	List<Car> li=qr.query(sql,new BeanListHandler<Car>(Car.class), userId,productId);
	return li;
}
}
