package com.example.secondmainproject.Mapper;


import com.example.secondmainproject.Dao.Entity.AboutEntity;
import com.example.secondmainproject.Model.AboutDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AboutMapper {

    AboutMapper INSTANCE = Mappers.getMapper(AboutMapper.class);

    AboutDto aboutToDto(AboutEntity aboutEntity);
}
