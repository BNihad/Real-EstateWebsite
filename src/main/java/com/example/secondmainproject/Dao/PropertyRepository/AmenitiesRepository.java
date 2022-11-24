package com.example.secondmainproject.Dao.PropertyRepository;

import com.example.secondmainproject.Dao.Entity.AmenitiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmenitiesRepository extends JpaRepository<AmenitiesEntity,Integer> {


}
