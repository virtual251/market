package servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bean.Product;
import service.ProductService;

public class AddBookServlet extends HttpServlet {
	Product pd=new Product();
	ProductService ps=new ProductService();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		boolean isMultipartContent=ServletFileUpload.isMultipartContent(request);
		if(!isMultipartContent){
			throw new RuntimeException("your form is not Multipart/form-data");
		}
		DiskFileItemFactory factory=new DiskFileItemFactory();
		ServletFileUpload sfu=new ServletFileUpload(factory);
		try {
			List<FileItem> fileItems=sfu.parseRequest(request);
			for(FileItem file:fileItems){
				if(file.isFormField()){
					processFormField(file);
				}else{
					processUploadField(file);
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ps.addBook(pd);
		System.out.println(pd.getId());
		System.out.println(pd.getCategory());
		System.out.println(pd.getDescription());
		System.out.println(pd.getImg_url());
		System.out.println(pd.getName());
		System.out.println(pd.getPnum());
		System.out.println(pd.getPrice());
	}
	private void processUploadField(FileItem file) {
		
		String filename=file.getName();
		String img_url=filename.substring(filename.lastIndexOf(File.separator)+1);
		pd.setImg_url(img_url);
		/*System.out.println(filename);
		try {
			InputStream in=file.getInputStream();
			File destDir=new File("WebRoot/upload/Öñ.jpg");
			System.out.println(destDir);
			OutputStream out=new FileOutputStream(destDir);
			byte[] b=new byte[1024];
			int len=0;
			while((len=in.read(b))!=-1){
				out.write(b, 0, len);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		try {
			InputStream is=file.getInputStream();
			String directoryRealPath=this.getServletContext().getRealPath("/upload");
			System.out.println(directoryRealPath);
			File storeDirectory=new File(directoryRealPath);
			if(!storeDirectory.exists()){
				storeDirectory.mkdirs();
			}
			File f=new File(storeDirectory,img_url);
			FileOutputStream fos=new FileOutputStream(f);
			int len=0;
			byte[] b=new byte[1024];
			while((len=is.read(b))!=-1){
				fos.write(b, 0, len);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void processFormField(FileItem file) {
		String Filename=file.getFieldName();
		String name = null;
		try {
			name = file.getString("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		if("name".equals(Filename)){
			pd.setName(name);
		}
		if("price".equals(Filename)){
			double price=Double.parseDouble(name);
			pd.setPrice(price);
		}
		if("pnum".equals(Filename)){
			int pnum=Integer.parseInt(name);
			pd.setPnum(pnum);
		}
		if("description".equals(Filename)){
			pd.setDescription(name);
		}
		if("category".equals(Filename)){
			pd.setCategory(name);
		}
		
		int num=ps.count("")+1;
		String id=num+"";
		pd.setId(id);
		
	}
	
	}

