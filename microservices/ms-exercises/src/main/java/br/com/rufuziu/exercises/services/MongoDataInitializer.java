package br.com.rufuziu.exercises.services;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;


@Component
public class MongoDataInitializer {


    private final MongoTemplate mongoTemplate;

    public MongoDataInitializer(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

}
