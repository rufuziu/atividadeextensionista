package br.com.rufuziu.ms_register_and_auth.repository;

import br.com.rufuziu.ms_register_and_auth.entity.Admin;
import br.com.rufuziu.ms_register_and_auth.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

//@Repository
public interface AdminRepository extends MongoRepository<Admin, String> {
    Boolean existsByEmail (String email);
    Boolean existsByEmailAndActiveFalse(String email);
    Optional<Admin> findByEmail(String email);
}
