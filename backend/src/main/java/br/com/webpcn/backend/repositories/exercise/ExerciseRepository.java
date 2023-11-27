package br.com.webpcn.backend.repositories.exercise;

import br.com.webpcn.backend.entities.exercise.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
}
