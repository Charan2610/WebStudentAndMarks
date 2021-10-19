package com.StudentMarkWeb;

import com.StudentMarkWeb.Dao.UserRepo;
import com.StudentMarkWeb.Models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class StudentMarkWebApplication implements CommandLineRunner {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private BCryptPasswordEncoder encoder;

	public static void main(String[] args) {
		SpringApplication.run(StudentMarkWebApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

//		Users user = new Users();
//		user.setUsername("Harry");
//		user.setEmail("harry@gmail.com");
//		user.setPassword(encoder.encode("12345"));
//		user.setType("ROLE_NORMAL");
//		userRepo.save(user);
	}
}
