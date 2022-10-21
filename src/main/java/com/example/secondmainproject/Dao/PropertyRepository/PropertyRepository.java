package com.example.secondmainproject.Dao.PropertyRepository;

import com.example.secondmainproject.Dao.Entity.PropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends JpaRepository<PropertyEntity,Integer> {

}
