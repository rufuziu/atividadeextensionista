package br.com.webpcn.backend.repositories.usertorole;

import br.com.webpcn.backend.entities.UserToRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserToRoleRepository extends
        JpaRepository<UserToRole,Long> {
}
