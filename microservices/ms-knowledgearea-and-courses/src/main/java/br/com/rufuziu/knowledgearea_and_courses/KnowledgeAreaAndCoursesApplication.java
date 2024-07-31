package br.com.rufuziu.knowledgearea_and_courses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("br.com.rufuziu.knowledgearea_and_courses.repository")
@ComponentScan("br.com.rufuziu.knowledgearea_and_courses.*")
public class KnowledgeAreaAndCoursesApplication {

	public static void main(String[] args) {
		SpringApplication.run(KnowledgeAreaAndCoursesApplication.class, args);
	}

}
