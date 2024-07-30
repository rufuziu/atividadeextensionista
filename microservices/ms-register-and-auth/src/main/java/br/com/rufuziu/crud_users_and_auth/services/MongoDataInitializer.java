package br.com.rufuziu.crud_users_and_auth.services;

import br.com.rufuziu.crud_users_and_auth.entity.Role;
import br.com.rufuziu.crud_users_and_auth.enums.ERole;
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

    private List<String> rolesToCheck = Arrays.asList("ROLE_ADMIN", "ROLE_STUDENT", "ROLE_TEACHER");

    @PostConstruct
    public void init() {

        //1 - INSERT ROLES
        if (mongoTemplate.find(
                new Query(Criteria.where("name").in(rolesToCheck)),
                Role.class).isEmpty()) {
            mongoTemplate.save(new Role(ERole.ROLE_ADMIN));
            mongoTemplate.save(new Role(ERole.ROLE_STUDENT));
            mongoTemplate.save(new Role(ERole.ROLE_TEACHER));
        }
    }
}
