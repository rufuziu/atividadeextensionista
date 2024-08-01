package br.com.rufuziu.knowledgearea_and_courses.services;

import br.com.rufuziu.knowledgearea_and_courses.dto.EducationLevelDTO;
import br.com.rufuziu.knowledgearea_and_courses.entity.EducationLevel;
import br.com.rufuziu.knowledgearea_and_courses.entity.KnowledgeArea;
import jakarta.annotation.PostConstruct;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class MongoDataInitializer {


    private final MongoTemplate mongoTemplate;

    public MongoDataInitializer(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    private List<EducationLevel> educationLevelsToCheck = Arrays.asList(
            new EducationLevel("Ensino Fundamental - Anos Iniciais"),
            new EducationLevel("Ensino Fundamental - Anos Finais"),
            new EducationLevel("Ensino Médio"));

    private List<String> generalKnowledgeAreaToCheck = Arrays.asList(
            "Língua Portuguesa",
            "Matemática",
            "Educação Física",
            "Artes");

    private List<String> specificOneKnowledgeAreaToCheck = Arrays.asList(
            "Ciências",
            "História",
            "Geografia",
            "Ensino Religioso");

    private List<String> specificTwoKnowledgeAreaToCheck = Arrays.asList(
            "Ciências da Natureza",
            "Ciências Humanas",
            "Língua Estrangeira");


    @PostConstruct
    public void init() {

        //1 - INSERT EDUCATION LEVEL
        if (mongoTemplate.find(
                new Query(Criteria.where("name")
                        .in(educationLevelsToCheck)),
                EducationLevel.class).isEmpty()) {
            for (EducationLevel educationLevel : educationLevelsToCheck) {
                mongoTemplate.save(educationLevel);
            }
        }

        //2 - INSERT KNOWLEDGE AREA
        //2.1 - GENERAL
        if (mongoTemplate.find(
                new Query(Criteria.where("name").in(generalKnowledgeAreaToCheck)),
                KnowledgeArea.class).isEmpty()) {

            for (String generalKnowledgeArea : generalKnowledgeAreaToCheck) {
                mongoTemplate.save(new KnowledgeArea(generalKnowledgeArea, educationLevelsToCheck.get(0)));
                mongoTemplate.save(new KnowledgeArea(generalKnowledgeArea, educationLevelsToCheck.get(1)));
                mongoTemplate.save(new KnowledgeArea(generalKnowledgeArea, educationLevelsToCheck.get(2)));
            }
        }
        //2.2 - SPECIFIC ONE
        if (mongoTemplate.find(
                new Query(Criteria.where("name").in(specificOneKnowledgeAreaToCheck)),
                KnowledgeArea.class).isEmpty()) {

            for (String specificOneKnowledgeArea : specificOneKnowledgeAreaToCheck) {
                mongoTemplate.save(new KnowledgeArea(specificOneKnowledgeArea, educationLevelsToCheck.get(0)));
                mongoTemplate.save(new KnowledgeArea(specificOneKnowledgeArea, educationLevelsToCheck.get(1)));
            }
        }
        //2.2 - SPECIFIC TWO
        if (mongoTemplate.find(
                new Query(Criteria.where("name").in(specificTwoKnowledgeAreaToCheck)),
                KnowledgeArea.class).isEmpty()) {

            for (String specificTwoKnowledgeArea : specificTwoKnowledgeAreaToCheck) {
                mongoTemplate.save(new KnowledgeArea(specificTwoKnowledgeArea, educationLevelsToCheck.get(2)));
            }
        }
    }
}
