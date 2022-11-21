package com.example.secondmainproject.Mapper;



import com.example.secondmainproject.Dao.Entity.user.UserEntity;
import com.example.secondmainproject.Model.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE= Mappers.getMapper(UserMapper.class);

    UserDto entityToDto(UserEntity userEntity);
}
