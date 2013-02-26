package models;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

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
	
	private String sortColumns;
	public String getSortColumns() {
		return sortColumns;
	}
	public void setSortColumns(String sortColumns) {
		this.sortColumns = sortColumns;
	}
	
	public String toString() {
		return new ToStringBuilder(this)
			.append("id",getId())
			.append("name",getName())
			.append("phone",getPhone())
			.append("addr",getAddr())
			.append("duty",getDuty())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getName())
			.append(getPhone())
			.append(getAddr())
			.append(getDuty())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof User == false) return false;
		if(this == obj) return true;
		User other = (User)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.append(getName(),other.getName())
			.append(getPhone(),other.getPhone())
			.append(getAddr(),other.getAddr())
			.append(getDuty(),other.getDuty())
			.isEquals();
	}
}
