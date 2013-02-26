package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import models.User;

import com.opensymphony.xwork2.ActionSupport;

public class UserController extends ActionSupport {
	
	private static List<User> users = new ArrayList<User>();
	static{
		for(int i=1; i<10; i++){
			User userInfo = new User();
			userInfo.id = i;
			userInfo.name = "name" + i;
			userInfo.phone = "phone" + i;
			userInfo.addr = "addr" + i;
			userInfo.duty = "duty" + i;
			
			users.add(userInfo);
		}
	}

	private String message;
	private User user;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
	public String returnUsers() throws Exception{
		return "users";
	}
	
	public String returnUser() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		user = users.get(id-1);
		return "user";
	}
	
	
	public String newUser() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		User userInfo = new User();
		userInfo.id = users.size()+1;
		userInfo.name = request.getParameter("name");
		userInfo.phone = request.getParameter("phone");
		userInfo.addr = request.getParameter("addr");
		userInfo.duty = request.getParameter("duty");
		users.add(userInfo);
		//TODO permanent save using mybatis "MybatisMain.java"
		
		message = "success";
		return "message";
	}
	
	public String updateUser() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		user = users.get(id-1).clone();
		user.id = id;
		user.name = request.getParameter("name");
		user.phone = request.getParameter("phone");
		user.addr = request.getParameter("addr");
		user.duty = request.getParameter("duty");
		users.set(id-1, user);
		//TODO permanent save using mybatis "MybatisMain.java"
		
		message = "success";
		return "message";
	}
}
