package com.example.secondmainproject.Dao.PropertyRepository;

import com.example.secondmainproject.Dao.Entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, Integer> {
}
