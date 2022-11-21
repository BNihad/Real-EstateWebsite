package com.example.secondmainproject.Dao.PropertyRepository;

import com.example.secondmainproject.Dao.Entity.PropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import java.util.List;

@Repository

public interface PropertyRepository extends JpaRepository<PropertyEntity,Integer> {

 @Query(value = "select * from properties e where e.property_name like %:keyword% or e.price like %:keyword% or e.property_location like %:keyword% or e.property_type like %:keyword% or e.baths like %:keyword%", nativeQuery = true)
  List<PropertyEntity> findByName(@Param("keyword") String keyword);

 @Query(value = "select * from properties e where e.property_name like %:keyword2%", nativeQuery = true)
 List<PropertyEntity> findByName1(@Param("keyword2") String keyword2);

 @Query(value = "select * from properties e where  cast(e.price as INT) < :keyword3 ", nativeQuery = true)
 List<PropertyEntity> findPrice(@Param("keyword3") Integer keyword3);





}
