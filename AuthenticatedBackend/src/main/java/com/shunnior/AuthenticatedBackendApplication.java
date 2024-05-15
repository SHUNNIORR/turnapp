package com.shunnior;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.shunnior.models.*;
import com.shunnior.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.shunnior.repository.RoleRepository;
import com.shunnior.repository.UserRepository;

@SpringBootApplication
public class AuthenticatedBackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(AuthenticatedBackendApplication.class, args);
	}

	@Bean
	CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncode, AccountRepository accountRepository){
		return args ->{
			if(roleRepository.findByAuthority("ADMIN").isPresent()) return;
			Role adminRole = roleRepository.save(new Role("ADMIN"));
			Role employeeRole = roleRepository.save(new Role("EMPLOYEE"));

			Set<Role> rolAdmin = new HashSet<>();
			rolAdmin.add(adminRole);

			Set<Role> rolEmployee = new HashSet<>();
			rolEmployee.add(employeeRole);

			List<EmployeeType> employeeTypeList = new ArrayList<>();
			List<EmployeeService> employeeServiceListList = new ArrayList<>();

			//ApplicationUser admin = new Admin(1, "admin","Jorge","Perez", "jorge@gmail.com", passwordEncode.encode("password"), rolAdmin);
			ApplicationUser user1 = new Employee(2,
					"jorge",
					"Jorge",
					"Perez",
					"jorge@gmail.com",
					passwordEncode.encode("12345678"),
					rolEmployee,
					employeeTypeList,
					employeeServiceListList,
					true);
			//ApplicationUser user2 = new ApplicationUser(3,"ariana","Jorge","Perez", "jorge@gmail.com",  passwordEncode.encode("12345678"),rolEmployee);

			//create accounts for jorge and ariana


			//userRepository.save(admin);
			userRepository.save(user1);
			//userRepository.save(user2);
		};
	}
}
