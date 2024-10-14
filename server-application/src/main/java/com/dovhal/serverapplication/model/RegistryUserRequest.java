package com.dovhal.serverapplication.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.sql.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class RegistryUserRequest {


    private String fullName;
    private String username;
    private String password;
    private String email;
    private String dateOfReg;

}
