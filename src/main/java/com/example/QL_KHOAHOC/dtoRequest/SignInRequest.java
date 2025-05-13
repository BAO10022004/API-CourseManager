package com.example.QL_KHOAHOC.dtoRequest;

public class SignInRequest {
    private String email;
    private String password;

    // Constructors
    public SignInRequest() {}

    public SignInRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Getters và setters
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
}
