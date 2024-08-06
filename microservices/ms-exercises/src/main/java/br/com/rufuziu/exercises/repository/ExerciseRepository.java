package br.com.rufuziu.exercises.repository;

import br.com.rufuziu.exercises.entity.Exercise;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExerciseRepository extends MongoRepository<Exercise, String> {
}
