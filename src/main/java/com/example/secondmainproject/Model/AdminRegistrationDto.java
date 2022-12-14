package com.example.secondmainproject.Model;


import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
@Data
public class AdminRegistrationDto {
    @NotBlank(message ="Adı daxil edin")
    private String firstName;
    @NotBlank(message ="Sayadı daxil edin")
    private String lastName;
    @NotBlank(message ="Emaili daxil edin")
    @Email(message = "Email doğru deyil")
    private String email;
    @NotBlank(message ="Şifrəni daxil edin")
    @Length(min = 8,message ="şifrə ən azı 8 simvol olmalidir")
    private String password;
    @NotBlank(message ="Şifrəni təkrar daxil edin")
    @Length(min = 8,message = "")
    private String rPassword;

    public AdminRegistrationDto(String firstName, String lastName, String email, String password, String rPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.rPassword = rPassword;
    }

    public AdminRegistrationDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getrPassword() {
        return rPassword;
    }

    public void setrPassword(String rPassword) {
        this.rPassword = rPassword;
    }
}
