package com.teaching.teaching;

import com.teaching.teaching.models.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TeachingApplication {
	public static ApplicationContext context;
	public static User currentUser;

	public static void main(String[] args) {
		SpringApplication.run(TeachingApplication.class, args);
	}

}
