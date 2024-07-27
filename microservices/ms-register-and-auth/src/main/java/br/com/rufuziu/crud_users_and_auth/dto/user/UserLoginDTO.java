package br.com.rufuziu.crud_users_and_auth.dto.user;

public class UserLoginDTO {
    private String id;
    private String email;
    private String token;

    public UserLoginDTO() {}

    public UserLoginDTO(String id, String email, String token) {
        this.id = id;
        this.email = email;
        this.token = token;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
