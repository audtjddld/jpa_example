package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;

@SpringBootApplication
@EntityScan
public class JpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }
    
    /*/
	@Autowired
	EntityManager em;
	
	@PostConstruct
	@Transactional
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
/**/	    
}
