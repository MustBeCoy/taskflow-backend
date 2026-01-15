package com.taskflow.taskflow.controller;


import com.taskflow.taskflow.dto.TaskDTO;
import com.taskflow.taskflow.entity.TaskEntity;
import com.taskflow.taskflow.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/user/{userId}")
    public ResponseEntity<TaskEntity> createTask(
            @PathVariable Long userId,
            @Valid @RequestBody TaskDTO dto) {

        TaskEntity task = new TaskEntity();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());

        return ResponseEntity.ok(taskService.createTask(userId, task));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskEntity> getTask(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskEntity> updateTask(
            @PathVariable Long id,
            @Valid @RequestBody TaskDTO dto) {

        TaskEntity task = new TaskEntity();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());

        return ResponseEntity.ok(taskService.updateTask(id, task));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok("Task deleted successfully");
    }
}
