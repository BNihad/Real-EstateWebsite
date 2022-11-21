package com.example.secondmainproject.service;

import com.example.secondmainproject.Dao.Entity.PropertyEntity;
import com.example.secondmainproject.Dao.PropertyRepository.PropertyRepository;
import com.example.secondmainproject.Mapper.PropertyMapper;
import com.example.secondmainproject.Model.PropertyDto;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {

   private final PropertyRepository propertyRepository;

    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    public List<PropertyDto> getAllProperties(){

        var propertyEntityList = propertyRepository.findAll();

        return propertyEntityList.parallelStream().
                map(propertyEntity-> PropertyMapper.INSTANCE.mapToDto(propertyEntity)).toList();
    }


    public PropertyEntity findById (Integer id){

        return propertyRepository.findById(id).get();
    }
    public String find (){

        return propertyRepository.toString();
    }



    public List<PropertyEntity> getAllPropertiesByName(String keyword){

        return propertyRepository.findByName(keyword);
    }

    public List<PropertyEntity> getAllPropertiesByName2(String keyword2){


        return propertyRepository.findByName1(keyword2);
    }
    public List<PropertyEntity> getAllPropertiesByPrice( Integer keyword  ){

        return propertyRepository.findPrice(keyword);
    }









//    public List<PropertyEntity> getByKeyword(String keyword){
//        if (keyword != null) {
//            return propertyRepository.findByKeyword(keyword);
//        }
//        return (List<PropertyEntity>) propertyRepository.findAll();
//    }
}
