package br.com.rufuziu.knowledgearea_and_subjects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("br.com.rufuziu.knowledgearea_and_subjects.repository")
@ComponentScan("br.com.rufuziu.knowledgearea_and_subjects.*")
public class KnowledgeAreaAndSubjectsApplication {

	public static void main(String[] args) {
		SpringApplication.run(KnowledgeAreaAndSubjectsApplication.class, args);
	}

}
