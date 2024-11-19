package org.example.aitestpro.dto;

public class AuthRequestDTO {
    private String username;
    private String password;

    @Override
    public String toString() {
        return "AuthRequestDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
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

    public AuthRequestDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public AuthRequestDTO() {
    }

}
