package br.com.rufuziu.crud_users_and_auth.dto.user;

import br.com.rufuziu.crud_users_and_auth.enums.ERole;

import java.time.LocalDateTime;
import java.util.Date;

public class UserDTO {
    private Long id;
    private String email;
    private String password;
    private LocalDateTime birthday;
    private LocalDateTime loginDate;
    private ERole role;

    public UserDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public LocalDateTime getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(LocalDateTime loginDate) {
        this.loginDate = loginDate;
    }

    public ERole getRole() {
        return role;
    }

    public void setRole(ERole role) {
        this.role = role;
    }
}
