package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

import bean.Product;

public class textDemo {
	public static void find() throws Exception{
		File srcDir=new File("WebRoot/upload/lz.jpg");
		File destDir=new File("WebRoot/temp/lz.jpg");
		InputStream in=new FileInputStream(srcDir);
		OutputStream out=new FileOutputStream(destDir);
		int len=0;
		byte[] b=new byte[1024];
		while((len=in.read(b))!=-1){
			out.write(b, 0, len);
		}
	}
	public static void main(String args[]){
	try {
		textDemo.find();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
	}
