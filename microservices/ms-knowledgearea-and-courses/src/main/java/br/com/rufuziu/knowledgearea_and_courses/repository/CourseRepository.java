package br.com.rufuziu.knowledgearea_and_courses.repository;

import br.com.rufuziu.knowledgearea_and_courses.entity.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepository extends MongoRepository<Course, String> {
}
