package com.sunbeam.dao;

import java.time.LocalDate;
import java.util.List;

import com.sunbeam.entity.UserRole;
import com.sunbeam.entity.User;

public interface UserDao {

	String registerUser(User user);

	User getUserDetailsById(Long userId);

	List<User> getAllUserDetails();

	List<User> getUserDetailsByRoleAndDate(UserRole role, LocalDate date);

	List<String> getUserLastNamesByRole(UserRole valueOf);

	List<User> getCompleteNameAndDobByRole(UserRole valueOf);

	String changePassword(String email, String oldPassword, String newPassword);

	String applyDiscount(UserRole userRole, LocalDate dob, double discount);

	String deleteUserDetailsById(Long userId);
}
