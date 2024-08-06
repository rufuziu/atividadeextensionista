package br.com.rufuziu.classes.repository;

import br.com.rufuziu.classes.entity.Class;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClassRepository extends MongoRepository<Class, String> {
}
