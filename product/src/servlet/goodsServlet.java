package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.PageBean;
import bean.Product;
import service.ProductService;

public class goodsServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	String category="";
	int pageSize = 8;
	
	int currentPage = 1;//当前页
	String currPage = request.getParameter("currentPage");//从上一页或下一页得到的数据
	if(currPage!=null&&!"".equals(currPage)){//第一次访问资源时，currPage可能是null
		currentPage = Integer.parseInt(currPage);
	}
	
	ProductService bs = new ProductService();
	//分页查询，并返回PageBean对象
	PageBean pb = bs.findBooksPage(currentPage,pageSize,category);
	
	request.setAttribute("pb", pb);
	request.getRequestDispatcher("/admin/goodsList.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
