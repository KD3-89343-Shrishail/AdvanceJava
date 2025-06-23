package com.sunbeam.beans;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class LoginBean {
   private String email;
   private String password;
   private String status;
   
   public LoginBean() {
	// TODO Auto-generated constructor stub
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}
   
   public void loginStatus() {
	   
	   
		try(UserDao userDao = new UserDaoImpl()) {
			User dbUser = userDao.findByEmail(email);
			if(dbUser != null && dbUser.getPasswd().equals(password)) {
				status="Login Success";
				
			}
			else {
				status="Login Failed";
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

   }
	
	
}
