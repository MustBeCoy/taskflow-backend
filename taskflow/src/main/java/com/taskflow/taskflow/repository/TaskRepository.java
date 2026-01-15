package com.taskflow.taskflow.repository;

import com.taskflow.taskflow.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
}
