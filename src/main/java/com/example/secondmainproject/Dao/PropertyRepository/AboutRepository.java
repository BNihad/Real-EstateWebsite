package com.example.secondmainproject.Dao.PropertyRepository;

import com.example.secondmainproject.Dao.Entity.AboutEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AboutRepository extends CrudRepository<AboutEntity, Integer> {
    Optional<AboutEntity> findById(Integer id);

}
