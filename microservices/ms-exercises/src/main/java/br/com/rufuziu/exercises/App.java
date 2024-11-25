package br.com.rufuziu.exercises;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("br.com.rufuziu.exercises.repository")
@ComponentScan("br.com.rufuziu.exercises.*")
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
