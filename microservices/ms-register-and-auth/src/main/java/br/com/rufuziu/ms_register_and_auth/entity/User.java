package br.com.rufuziu.ms_register_and_auth.entity;

import br.com.rufuziu.ms_register_and_auth.dto.user.UserDTO;
import jakarta.validation.constraints.Email;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


//@Document(collection = "users")
public class User {
    @Id
    private String id;
    @Email
    private String email;
    private String password;
    private LocalDateTime birthday;
    private Boolean active;
    private LocalDateTime loginDate;
    @DBRef
    private Set<Role> roles = new HashSet<>();

    public User() {
        this.active = false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDateTime getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(LocalDateTime loginDate) {
        this.loginDate = loginDate;
    }

    public void updateUser(UserDTO userDTO){
        this.email = userDTO.getEmail();
        this.birthday = userDTO.getBirthday();
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> role) {
        this.roles = role;
    }
}
