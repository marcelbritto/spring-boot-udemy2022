package br.com.marcbritto.pontointeligente.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication()
public class SpringBootInitialApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootInitialApplication.class, args);
	}

}
