package dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import bean.User;
import util.C3P0Util;

public class UserDao {

	public void addUser(User user) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "INSERT INTO USER(id,username,password,email,telephone,activecode,state,registTime) "
				+ "VALUES(?,?,?,?,?,?,?,?)";
		qr.update(sql, user.getId(),user.getUsername(), user.getPassword(),
				 user.getEmail(), user.getTelephone(),
				 user.getActiveCode(), user.getState(),
				user.getRegistTime());

	}

	// 根据激活码查找用户
	public User findUserByActiveCode(String activeCode) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from user where activecode=?",
				new BeanHandler<User>(User.class), activeCode);
	}

	// 修改用户激活状态
	public void activeCode(String activeCode) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("update user set state=1 where activecode=?", activeCode);

	}

	// 用户登录
	public User findUserByUserNameAndPassword(String username, String password)
			throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from user where username=? and password=?",
				new BeanHandler<User>(User.class), username, password);
	}

	// 根据id查找用户
	public User findUserById(String id) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from user where id=?", new BeanHandler<User>(
				User.class), id);
	}

	// 修改用户信息
	public void modifyUser(User user) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("update user set password=? , telephone=? where id=?",user.getPassword(),user.getTelephone(),user.getId());
		
	}
}
