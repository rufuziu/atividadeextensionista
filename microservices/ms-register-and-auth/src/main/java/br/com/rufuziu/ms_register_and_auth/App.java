package br.com.rufuziu.ms_register_and_auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("br.com.rufuziu.ms_register_and_auth.repository")
@ComponentScan("br.com.rufuziu.ms_register_and_auth.*")
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
