package com.taskflow.taskflow.repository;

import com.taskflow.taskflow.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
