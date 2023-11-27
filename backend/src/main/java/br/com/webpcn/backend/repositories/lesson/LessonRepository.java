package br.com.webpcn.backend.repositories.lesson;

import br.com.webpcn.backend.entities.lesson.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
