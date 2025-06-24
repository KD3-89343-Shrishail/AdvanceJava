package com.sunbeam.entity;

import java.time.LocalDate;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="Users")
public class User {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name = "First_Name",length = 30)
	private String firstName;
	

	@Column(name = "Last_Name",length = 30)
	private String lastName;
	
	@Column(nullable =false,unique = true)
	private String email;
	
	@Column(length = 300,nullable = false)
	private String password;
	
	@Transient
	private String confirmPassword;
	
	@Column(name="Subscription_Amount")
	private double subscriptionAmount;
	
	@Enumerated(EnumType.STRING)
	private UserRole userRole;
	
	@Lob
	private byte[] image;
	
	
	private LocalDate dob;

	public User(String firstName, String lastName, String email, String password, double subscriptionAmount,
			UserRole userRole, LocalDate dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.subscriptionAmount = subscriptionAmount;
		this.userRole = userRole;
		this.dob = dob;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public double getSubscriptionAmount() {
		return subscriptionAmount;
	}

	public void setSubscriptionAmount(double subscriptionAmount) {
		this.subscriptionAmount = subscriptionAmount;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", subscriptionAmount=" + subscriptionAmount + ", userRole=" + userRole + ", dob=" + dob + "]";
	}
	
	

}
