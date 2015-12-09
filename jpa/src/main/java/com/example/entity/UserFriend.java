package com.example.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class UserFriend {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long userFriendId;
	
	@ManyToOne
	@JoinColumn(name="_id")
	User user;
	
	String friendName;
	
	@Temporal(TemporalType.TIMESTAMP)	
	Date registerd;

	@PrePersist
	void prePersist() {
		registerd = new Date();
	}
	
	public Long getUserFriendId() {
		return userFriendId;
	}

	public void setUserFriendId(Long userFriendId) {
		this.userFriendId = userFriendId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFriendName() {
		return friendName;
	}

	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}

}
