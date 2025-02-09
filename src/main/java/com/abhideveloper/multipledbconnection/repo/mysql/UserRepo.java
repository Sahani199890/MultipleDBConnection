package com.abhideveloper.multipledbconnection.repo.mysql;

import com.abhideveloper.multipledbconnection.entity.mysql.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity, Long> {
}
