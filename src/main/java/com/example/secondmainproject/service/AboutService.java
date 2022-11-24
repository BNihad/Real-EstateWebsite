package com.example.secondmainproject.service;

import com.example.secondmainproject.Dao.PropertyRepository.AboutRepository;
import com.example.secondmainproject.Mapper.AboutMapper;
import com.example.secondmainproject.Model.AboutDto;
import org.springframework.stereotype.Service;

@Service
public class AboutService {
    private AboutRepository aboutRepository;

    public AboutService(AboutRepository aboutRepository) {
        this.aboutRepository = aboutRepository;
    }

    public AboutDto getAbout() {
        return AboutMapper.INSTANCE.aboutToDto(aboutRepository.findById(1).get());
    }
}
