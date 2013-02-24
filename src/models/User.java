package models;

public class User {
	public Integer id;
	public String name;
	public String phone;
	public String addr;
	public String duty;
	
	public User clone(){
		User u = new User();
		u.id = id;
		u.name = name;
		u.phone = phone;
		u.addr = addr;
		u.duty = duty;
		return u;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}
}
