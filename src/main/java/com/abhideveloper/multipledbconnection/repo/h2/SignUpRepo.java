package com.abhideveloper.multipledbconnection.repo.h2;

import org.springframework.data.jpa.repository.JpaRepository;
import com.abhideveloper.multipledbconnection.entity.h2.SignUpEntity;

import java.util.Optional;


public interface SignUpRepo extends JpaRepository<SignUpEntity,Long> {
    Optional<SignUpEntity> findByEmail(String email);
}
