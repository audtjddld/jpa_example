package com.example.user.vo;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "user")
public class User extends SearchVO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	String _id;

	String balance;

	// @Pattern(regexp="/[0-9]+/")
	int age;

	@NotNull
	@NotEmpty
	String eyeColor;

	@Column(nullable = false)
	String name;

	@Enumerated(EnumType.STRING)
	Gender gender;

	@NotNull
	@NotEmpty
	String company;

	@Email
	@Column(unique = true)
	String email;

	@NotNull
	@NotEmpty
	String phone;


	Address address;
	String about;

	// 자동 등록
	// @Column(name="registerd", columnDefinition="TIMESTAMP DEFAULT
	// CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	Date registerd;

	String greeting;

	String tag;

	@JsonIgnore
	@OneToMany(mappedBy = "user")
	List<UserFriend> friends;

	@PrePersist
	void prePersist() {
		registerd = new Date();
	}

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

	public Date getRegisterd() {
		return registerd;
	}

	public void setRegisterd(Date registerd) {
		this.registerd = registerd;
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

	public List<UserFriend> getFriends() {
		return friends;
	}

	public void setFriends(List<UserFriend> friends) {
		this.friends = friends;
	}

	@Override
	public String toString() {
		return "User [_id=" + _id + ",  balance=" + balance + ", age=" + age + ", eyeColor=" + eyeColor + ", name="
				+ name + ", gender=" + gender + ", company=" + company + ", email=" + email + ", phone=" + phone
				+ ", address=" + address + ", about=" + about + ", registerd=" + registerd + ", greeting=" + greeting
				+ ", tag=" + tag + ", friends=" + friends + "]";
	}

}
