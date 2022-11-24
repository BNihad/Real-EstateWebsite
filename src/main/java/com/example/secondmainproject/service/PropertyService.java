package com.example.secondmainproject.service;

import com.example.secondmainproject.Dao.Entity.AmenitiesEntity;
import com.example.secondmainproject.Dao.Entity.PropertyEntity;
import com.example.secondmainproject.Dao.PropertyRepository.AmenitiesRepository;
import com.example.secondmainproject.Dao.PropertyRepository.PropertyRepository;
import com.example.secondmainproject.Mapper.PropertyMapper;
import com.example.secondmainproject.Model.PropertyDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class PropertyService {

   private final PropertyRepository propertyRepository;

   @Autowired
    private AmenitiesRepository amenitiesRepository;

    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    public List<PropertyDto> getAllProperties(){

        var propertyEntityList = propertyRepository.findAll();

        return propertyEntityList.parallelStream().
                map(propertyEntity-> PropertyMapper.INSTANCE.mapToDto(propertyEntity)).toList();
    }

    public void saveProperty2(PropertyDto propertyDto) throws ParseException {


        var propertyDetails=PropertyMapper.INSTANCE.mapToEntity(propertyDto);
        propertyRepository.save(propertyDetails);
    }


    public PropertyEntity findById (Integer id){

        return propertyRepository.findById(id).get();
    }

    public AmenitiesEntity findByIdAmenities (Integer id){

        return amenitiesRepository.findById(id).get();
    }

    public PropertyEntity findByParameter(Integer id){

        return propertyRepository.findById(id).get();
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

    public void saveProperty(PropertyEntity propertyEntity) {
        propertyRepository.save(propertyEntity);
    }

    public void deleteProperty(Integer id) {
        propertyRepository.deleteById(id);
    }









//    public List<PropertyEntity> getByKeyword(String keyword){
//        if (keyword != null) {
//            return propertyRepository.findByKeyword(keyword);
//        }
//        return (List<PropertyEntity>) propertyRepository.findAll();
//    }
}
