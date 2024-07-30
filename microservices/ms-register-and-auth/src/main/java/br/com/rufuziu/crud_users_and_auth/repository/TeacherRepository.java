package br.com.rufuziu.crud_users_and_auth.repository;

import br.com.rufuziu.crud_users_and_auth.entity.Student;
import br.com.rufuziu.crud_users_and_auth.entity.Teacher;
import br.com.rufuziu.crud_users_and_auth.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

//@Repository
public interface TeacherRepository extends MongoRepository<Teacher, String> {
    Boolean existsByEmail (String email);
    Boolean existsByEmailAndActiveFalse(String email);
    Optional<Teacher> findByEmail(String email);
//    @Modifying
//    @Query("UPDATE users u SET u.active = TRUE WHERE u.email = ?1")
//    int activateUserByEmail(String email);
}
