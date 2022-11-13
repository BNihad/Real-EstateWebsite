package com.example.secondmainproject.Mapper;

import com.example.secondmainproject.Dao.Entity.ContactEntity;
import com.example.secondmainproject.Model.ContactDto;
import org.springframework.stereotype.Component;

@Component
public class ContactMapper {

    public ContactEntity contactEntityDto(ContactDto contactDto) {
        return new ContactEntity(

                contactDto.getName(),
                contactDto.getEmail(),
                contactDto.getSubject(),
                contactDto.getMessage()
        );
    }
}

