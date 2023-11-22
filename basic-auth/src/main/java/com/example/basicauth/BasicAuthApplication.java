package com.example.basicauth;

import com.example.basicauth.dto.CreateUserRequest;
import com.example.basicauth.model.Role;
import com.example.basicauth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Set;

@SpringBootApplication
@RequiredArgsConstructor
public class BasicAuthApplication implements CommandLineRunner {

	private final UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(BasicAuthApplication.class, args);
	}
	public void run(String... args) throws Exception {
		createDummyUser();
	}

	private void createDummyUser(){
		CreateUserRequest user = CreateUserRequest.builder()
				.name("Dummy User")
				.username("dummy")
				.password("user")
				.authorities(Set.of(Role.ROLE_USER))
				.build();
		userService.create(user);

		CreateUserRequest admin = CreateUserRequest.builder()
				.name("Dummy Admin")
				.username("admin")
				.password("dummy")
				.authorities(Set.of(Role.ROLE_ADMIN))
				.build();
		userService.create(admin);

	}

}
