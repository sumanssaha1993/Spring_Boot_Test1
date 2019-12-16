package com.suman.test.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name = "user", uniqueConstraints = {@UniqueConstraint(columnNames = "user_name")})
@Table(schema = "use",name="user")
public class UserDTO {

	@Id
	@Column(name = "user_name", unique = true, nullable = false, length = 255)
	private String user_name;
	
	@Column(name = "password",  nullable = false, length = 45)
	private String password;

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDTO [user_name=" + user_name + ", password=" + password + "]";
	}
	
}
