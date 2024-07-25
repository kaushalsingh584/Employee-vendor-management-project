package com.credmarg.assignment;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

class AssignmentApplicationTests {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "ks@12345";
        String encodedPassword = encoder.encode(rawPassword);
         
        System.out.println(encodedPassword);
	}

}
