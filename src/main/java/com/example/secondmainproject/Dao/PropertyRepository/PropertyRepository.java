package com.example.secondmainproject.Dao.PropertyRepository;

import com.example.secondmainproject.Dao.Entity.PropertyEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface PropertyRepository extends JpaRepository<PropertyEntity,Integer> {

//  List<PropertyEntity>findByProperty_name(String property_name);



}
