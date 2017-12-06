package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import bean.Order;
import bean.OrderItem;
import bean.Product;
import util.C3P0Util;
import util.ManagerThreadLocal;

public class OrderDao {
	// ��Ӷ���
	public void addOrder(Order order) throws SQLException {
	/*	QueryRunner qr = new QueryRunner();
		qr.update(ManagerThreadLocal.getConnection(),
				"INSERT INTO orders VALUES(?,?,?,?,?,?,?,?)", order.getId(),
				order.getMoney(), order.getReceiverAddress(), order
						.getReceiverName(), order.getReceiverPhone(), order
						.getPaystate(), order.getOrdertime(), order.getUserId()
						);*/
	}

	// �����û�id��ѯ���ж���
	public List<Order> findOrders(String string) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql="select * from orders where userId=?";
		System.out.println(string);
		List<Order> li=qr.query(sql,new BeanListHandler<Order>(Order.class),string);
		for(Order i:li){
			System.out.println(i);
			System.out.println(i.getId());
			System.out.println(i.getOrdertime());
			System.out.println(i.getReceiverAddress());
			System.out.println(i.getReceiverName());
			System.out.println(i.getReceiverPhone());
			System.out.println(i.getUserId());
			
		}
		return li;
	}

	// ��ѯָ���û��Ķ�����Ϣ
	public Order findOrdersByOrderId(String orderid) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		// �õ�һ������
		Order order = qr.query("select * from orders where id=?",
				new BeanHandler<Order>(Order.class), orderid);
		// �õ���ǰ�����е����ж�����
		// List<OrderItem> orderItems =
		// qr.query("select * from orderItem where order_id=? ", new
		// BeanListHandler<OrderItem>(OrderItem.class),orderid);
		// �õ����ж������е���Ʒ��Ϣ
		// List<Product> products =
		// qr.query("select * from products where id in(select product_id from orderitem where order_id=?)",
		// new BeanListHandler<Product>(Product.class),orderid);

		List<OrderItem> orderItems = qr
				.query("SELECT * FROM orderitem o,products p WHERE p.id=o.product_id AND order_id=?",
						new ResultSetHandler<List<OrderItem>>() {

							public List<OrderItem> handle(ResultSet rs)
									throws SQLException {
								List<OrderItem> orderItems = new ArrayList<OrderItem>();
								while (rs.next()) {

									// ��װOrderItem����
									OrderItem oi = new OrderItem();
									oi.setBuynum(rs.getInt("buynum"));
									// ��װProduct����
									Product p = new Product();
									p.setName(rs.getString("name"));
									p.setPrice(rs.getDouble("price"));
									// ��ÿ��p�����װ��OrderItem������
									oi.setP(p);
									// ��ÿ��OrderItem�����װ��������
									orderItems.add(oi);
								}
								return orderItems;
							}

						}, orderid);

		// �����еĶ�����orderItems��ӵ���������Order��
		//order.setOrderItems(orderItems);

		return order;
	}

	// �޸Ķ���֧��״̬
	public void modifyOrderState(String orderid) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("update orders set paystate=1 where id=?", orderid);
	}
}
