package com.example.secondmainproject.Mapper;

import com.example.secondmainproject.Dao.Entity.PropertyEntity;
import com.example.secondmainproject.Model.PropertyDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PropertyMapper {
    PropertyMapper INSTANCE = Mappers.getMapper(PropertyMapper.class);

    PropertyDto mapToDto(PropertyEntity propertyEntity);

    PropertyEntity mapToEntity(PropertyDto propertyDto);

}
