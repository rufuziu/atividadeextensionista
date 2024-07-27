package br.com.rufuziu.crud_users_and_auth.services;

import br.com.rufuziu.crud_users_and_auth.entity.Role;
import br.com.rufuziu.crud_users_and_auth.enums.ERole;
import jakarta.annotation.PostConstruct;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class MongoDataInitializer {


    private final MongoTemplate mongoTemplate;

    public MongoDataInitializer(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @PostConstruct
    public void init() {
        // Define your data here
        //if (mongoTemplate.find(new Query(Criteria.where("name").is("example")), YourDocumentClass.class).isEmpty()) {
        mongoTemplate.save(new Role(ERole.ROLE_ADMIN));
        mongoTemplate.save(new Role(ERole.ROLE_STUDENT));
        mongoTemplate.save(new Role(ERole.ROLE_TEACHER));
    }
}
