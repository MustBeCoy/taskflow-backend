package com.taskflow.taskflow.service;

import com.taskflow.taskflow.entity.TaskEntity;
import com.taskflow.taskflow.entity.UserEntity;
import com.taskflow.taskflow.exception.ResourceNotFoundException;
import com.taskflow.taskflow.repository.TaskRepository;
import com.taskflow.taskflow.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskService(TaskRepository taskRepository,
                       UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public TaskEntity createTask(Long userId, TaskEntity task) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        task.setUser(user);
        task.setStatus("PENDING");
        task.setCreatedAt(LocalDateTime.now());

        return taskRepository.save(task);
    }

    public TaskEntity getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));
    }

    public TaskEntity updateTask(Long id, TaskEntity updatedTask) {
        TaskEntity task = getTaskById(id);
        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        TaskEntity task = getTaskById(id);
        taskRepository.delete(task);
    }
}
