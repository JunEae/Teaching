package com.teaching.teaching.dto;


import lombok.Data;

@Data
public class SignupRequest {
    private String userName;
    private int userAge;
    private String password;
    private String email;

}
