package edu.ifrn.itaretif;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ItaretifApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItaretifApplication.class, args);
		
		System.out.print(new BCryptPasswordEncoder().encode("123"));
	}
		
}
