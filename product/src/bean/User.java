package bean;

import java.util.Date;

public class User {
	private String id; // �û����
	private String username; // �û�����
	private String password; // �û�����
	private String email; // �û�����
	private String telephone; // �û���ϵ�绰
	private String activeCode; // ������
	private int state; // �û�״̬
	private Date registTime;// ע��ʱ��
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getActiveCode() {
		return activeCode;
	}
	public void setActiveCode(String activeCode) {
		this.activeCode = activeCode;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Date getRegistTime() {
		return registTime;
	}
	public void setRegistTime(Date registTime) {
		this.registTime = registTime;
	}
	
	
}
