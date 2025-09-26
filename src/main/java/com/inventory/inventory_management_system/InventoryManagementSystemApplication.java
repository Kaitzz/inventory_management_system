package com.inventory.inventory_management_system;

import com.inventory.inventory_management_system.model.User;
import com.inventory.inventory_management_system.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class InventoryManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryManagementSystemApplication.class, args);
	}

	@Bean
	public CommandLineRunner initDatabase(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			// Create a default user
			if (userRepository.findByUsername("user").isEmpty()) {
				User user = new User();
				user.setUsername("user");

				user.setPassword(passwordEncoder.encode("password"));
				user.setRoles("ROLE_USER");
				userRepository.save(user);
				System.out.println("Created default user 'user' with password 'password'");
			}
		};
	}

}
