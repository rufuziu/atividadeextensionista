package br.com.rufuziu.knowledgearea_and_courses.dto.user;

import java.util.HashSet;
import java.util.Set;

public class UserToActivateDTO {
    private String email;
    private Set<Role> roles = new HashSet<>();

    public UserToActivateDTO() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
