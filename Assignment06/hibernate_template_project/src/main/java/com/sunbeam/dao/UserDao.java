package com.sunbeam.dao;

import java.time.LocalDate;
import java.util.List;

import com.sunbeam.entities.User;
import com.sunbeam.entities.UserRole;

public interface UserDao {
	
	//add a method - to register new user - insert
	String registerUser(User user);
	User getUserDetailsById(Long id);
	List<User> getAllUserDetails();
	List<User> getUserDetailsByRoleAndDate(UserRole role, LocalDate date);
	List<String> getUserLastNameByRole(UserRole valueOf);
	List<User> getCompleteNameAndDobByRole(UserRole valueOf);
	String changePassword(String email, String oldPassword, String newPassword);
	String applyDiscount(UserRole userRole, LocalDate dob, double discount);
	String deleteUserDetailsById(Long userId);
}
