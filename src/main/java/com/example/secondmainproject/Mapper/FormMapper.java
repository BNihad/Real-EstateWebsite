package com.example.secondmainproject.Mapper;

import com.example.secondmainproject.Dao.Entity.ContactEntity;
import com.example.secondmainproject.Dao.Entity.FormEntity;
import com.example.secondmainproject.Model.ContactDto;
import com.example.secondmainproject.Model.FormDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
public class FormMapper {

    public FormEntity formEntity(FormDto formDto) {
        return new FormEntity(

                formDto.getName(),
                formDto.getLastname(),
                formDto.getPhone(),
                formDto.getEmail(),
                formDto.getDate(),
                formDto.getTime()
        );
    }
}
