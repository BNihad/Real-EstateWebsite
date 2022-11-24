package com.example.secondmainproject.service;

import com.example.secondmainproject.Dao.PropertyRepository.FormRepository;
import com.example.secondmainproject.Mapper.FormMapper;
import com.example.secondmainproject.Model.ContactDto;
import com.example.secondmainproject.Model.FormDto;
import org.springframework.stereotype.Service;

@Service
public class FormService {


    private FormRepository formRepository;
    private FormMapper formMapper;

    public FormService(FormRepository formRepository, FormMapper formMapper) {
        this.formRepository = formRepository;
        this.formMapper = formMapper;
    }


    public boolean saveForm(FormDto formDto) {
        formRepository.save(formMapper.formEntity(formDto));
        return true;
    }
}
