package com.example.secondmainproject.Model;

import lombok.*;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class FormDto {

    private String name;


    private String lastname;



    private String phone;


    private String email;


    private String date;


    private String time;



}
