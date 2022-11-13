package com.example.secondmainproject.service;

import com.example.secondmainproject.Dao.PropertyRepository.ContactRepository;
import com.example.secondmainproject.Mapper.ContactMapper;
import com.example.secondmainproject.Model.ContactDto;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    private ContactRepository contactRepository;
    private ContactMapper contactMapper;

    public ContactService(ContactRepository contactRepository, ContactMapper contactMapper) {
        this.contactRepository = contactRepository;
        this.contactMapper = contactMapper;
    }

    public boolean saveContact(ContactDto contactDto) {
        contactRepository.save(contactMapper.contactEntityDto(contactDto));
        return true;
    }
}
