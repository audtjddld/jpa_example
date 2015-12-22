package com.example.user.vo;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


public class UserVO  {
	
	String _id;
	
	String balance;

	int age;
	
	@NotNull
	@NotEmpty
	String eyeColor;
	
	
	String name;
	
	
	Gender gender;
	
	@NotNull
	@NotEmpty
	String company;
	
	@Email
	String email;
	
	@NotNull
	@NotEmpty
	String phone;
	
	Address address;
	
	String about;
	
	String greeting;
	
	String tag;
	
	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEyeColor() {
		return eyeColor;
	}

	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	@Override
	public String toString() {
		return "UserVO [_id=" + _id + ", balance=" + balance + ", age=" + age + ", eyeColor=" + eyeColor + ", name="
				+ name + ", gender=" + gender + ", company=" + company + ", email=" + email + ", phone=" + phone
				+ ", address=" + address + ", about=" + about + ", greeting=" + greeting + ", tag=" + tag + "]";
	}


	
}
