package com.credmarg.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SpringBootApplication
public class AssignmentApplication {
	
	@Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        return new InMemoryUserDetailsManager();
    }


	public static void main(String[] args) {
		SpringApplication.run(AssignmentApplication.class, args);
	}

}
