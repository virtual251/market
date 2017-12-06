package util;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;


public class SendJMail {
	
		/*public static boolean sendMail(String email, String emailMsg) {
		
		String from = "2524777242@qq.com"; 				// �ʼ������˵��ʼ���ַ
		String to = email; 										// �ʼ������˵��ʼ���ַ
		final String username = "2524777242@qq.com";  	//�����˵��ʼ��ʻ�
		final String password = "w1233211234567";   					//�����˵��ʼ�����


		//����Properties����,���û�����Ϣ
		Properties props = new Properties();

		//�����ʼ��������ĵ�ַ
		props.setProperty("mail.transport.protocol", "smtp");//���÷����ʼ�ʹ�õ�Э��
		props.setProperty("mail.smtp.host", "smtp.qq.com"); // ָ����smtp������
		props.setProperty("mail.smtp.auth", "true");
		//����Session����,session�����ʾ�����ʼ��Ļ�����Ϣ
		Session session = Session.getInstance(props);
		//�������������Ϣ
		session.setDebug(true);
		try {
			//Message��ʵ�������ʾһ������ʼ�
			MimeMessage message = new MimeMessage(session);
			//���÷����˵ĵ�ַ
			message.setFrom(new InternetAddress(from));
			//��������
			message.setSubject("�û�����");
			//�����ʼ����ı�����
			//message.setText("Welcome to JavaMail World!");
			message.setContent(emailMsg,"text/html;charset=utf-8");// ע��ɹ�����<a href='http://www.product.com?activeCode=ffddff14'>����</a>���¼
			//��session�Ļ����л�ȡ�����ʼ��Ķ���
			Transport transport=session.getTransport();
			//�����ʼ�������
			transport.connect("smtp.qq.com",25, username, password);
			//�����ռ��˵�ַ,��������Ϣ
			transport.sendMessage(message,new Address[]{new InternetAddress(to)});
			transport.close();
			return true;
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
	}*/
	public static boolean sendM(String emails, String emailMsg){
		try{
		Email email = new SimpleEmail();
		email.setHostName("smtp.qq.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("2524777242","zzqxdjufuxhpebgb"));
		email.setSSLOnConnect(true);
		email.setFrom("2524777242@qq.com");
		email.setSubject("�����ʼ����Կ���");
		email.setMsg(emailMsg);
		email.addTo(emails);
		email.send();
		return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		}
	
}
