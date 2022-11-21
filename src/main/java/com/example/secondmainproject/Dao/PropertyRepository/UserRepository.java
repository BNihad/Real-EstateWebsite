package com.example.secondmainproject.Dao.PropertyRepository;


import com.example.secondmainproject.Dao.Entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
   UserEntity findByEmail(String email);
   @Query(value = "select * from users_roles cr  join user1 c on cr.user_id=c.id join role rd on cr.role_id = rd.id and rd.role_name=?1 ",nativeQuery = true)
   List<UserEntity> findByRole(String role);
   Optional<UserEntity>findUserByEmail(String email);
//    Boolean existsByEmail(String email);
}
