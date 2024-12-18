package org.example.aitestpro.dto;

public class AuthRegisterDTO {
    private String username;
    private String password;
    private String email;

    public AuthRegisterDTO(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
    public AuthRegisterDTO() {
    }

    @Override
    public String toString() {
        return "AuthRegisterDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
