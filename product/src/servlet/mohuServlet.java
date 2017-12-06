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

public class mohuServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 response.setContentType("text/html;charset=UTF-8");
		String name=request.getParameter("name");
		System.out.println(name);
		ProductService productsearch=new ProductService();
		List<Product> li=productsearch.searchBooks("", "", name, "", "");
		int pageSize=8;
		int currentPage = 1;
		String currPage = request.getParameter("currentPage");//从上一页或下一页得到的数据
		if(currPage!=null&&!"".equals(currPage)){//第一次访问资源时，currPage可能是null
			currentPage = Integer.parseInt(currPage);
		}
		int count=li.size();
		int totalPage = (int)Math.ceil(count*1.0/pageSize);
		PageBean pb = new PageBean();
		pb.setProducts(li);
		pb.setCount(count);
		pb.setCurrentPage(currentPage);
		pb.setPageSize(pageSize);
		pb.setTotalPage(totalPage);
		//在pageBean中添加属性，用于点击上一页或下一页时使用
		pb.setCategory("");
		
		
		request.setAttribute("pb", pb);
		request.getRequestDispatcher("/product_list.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request,response);
	}
		
}
