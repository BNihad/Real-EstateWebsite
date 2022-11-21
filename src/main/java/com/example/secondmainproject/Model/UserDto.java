package com.example.secondmainproject.Model;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data

@Setter
@Getter
public class UserDto {

    private String first_name;

    private String last_name;

    private String email;
    private String password;
    @NotBlank(message ="Şifrəni təkrar daxil edin")
    @Length(min = 8,message = "")
    private String rPassword;



    public UserDto() {
    }

    public UserDto(String first_name, String last_name, String email) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
    }

    public UserDto(String first_name, String last_name, String email, String password, String rPassword) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.rPassword = rPassword;
    }
}
