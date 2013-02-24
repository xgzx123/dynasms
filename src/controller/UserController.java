package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.User;

import com.et.mvc.JsonView;
import com.et.mvc.View;

public class UserController extends ApplicationController{
	public View getUsers() throws Exception{
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("total", users.size());
		result.put("rows", users);
		
		return new JsonView(result);
	}
	
	public View getUser(Integer id) throws Exception{
		User user = users.get(id-1);
		return new JsonView(user);
	}
	
	public View save(User user) throws Exception{
		Map<String,Object> result = new HashMap<String,Object>();
		if (user.name.length() == 0){
			result.put("failure", true);
			result.put("msg", "Name is required!");
		} else {
			result.put("success", true);
			user.id = users.size()+1;
			users.add(user);
		}
		View view = new JsonView(result);
		view.setContentType("text/html;charset=utf-8");
		return view;
	}
	
	public View update(Integer id) throws Exception{
		Map<String,Object> result = new HashMap<String,Object>();
		User user = users.get(id-1).clone();
		updateModel(user);
		if (user.name.length() == 0){
			result.put("failure", true);
			result.put("msg", "Name is required!");
		} else {
			result.put("success", true);
			user.id = id;
			users.set(id-1, user);
		}
		View view = new JsonView(result);
		view.setContentType("text/html;charset=utf-8");
		return view;
	}
	
	
	//init
	private static List<User> users = new ArrayList<User>();
	static{
		for(int i=1; i<10; i++){
			User user = new User();
			user.id = i;
			user.name = "name" + i;
			user.phone = "phone" + i;
			user.addr = "addr" + i;
			user.duty = "duty" + i;
			
			users.add(user);
		}
	}
}
