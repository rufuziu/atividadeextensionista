package br.com.rufuziu.ms_register_and_auth.repository;


import br.com.rufuziu.ms_register_and_auth.entity.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role,String> {
    Optional<Role> findByName(String name);
}
