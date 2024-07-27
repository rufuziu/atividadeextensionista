package br.com.rufuziu.crud_users_and_auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("br.com.rufuziu.crud_users_and_auth.repository")
@ComponentScan("br.com.rufuziu.crud_users_and_auth.*")
public class CrudUsersAndAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudUsersAndAuthApplication.class, args);
	}

}
