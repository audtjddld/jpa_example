package com.example;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;

import com.example.entity.Gender;
import com.example.entity.User;

@SpringBootApplication
@EntityScan
public class JpaApplication {

	@Autowired
	EntityManager em;
	
	@PostConstruct
	void init() {
		 User user = new User();
		 user.setName("홍길동");
		 user.setAge(12);
		 user.setBalance("123456");
		 user.setEyeColor("blue");
		 user.setGender(Gender.male);
		 user.setCompany("DH");
		 user.setEmail("a@a.a");
		 user.setPhone("0212345678");
		 user.setAbout("123124");
		 user.setGreeting("Hi~");
		 user.setTag("data");
		 
		 em.persist(user);
	}
	
    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }
}
