package org.example.taskmanager.controller;

import org.example.taskmanager.service.TaskService;
import org.example.taskmanager.model.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/accounts/{accountId}/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task create(@PathVariable Long accountId, @Valid @RequestBody Task task) {
        return taskService.createTask(accountId, task);
    }

    @GetMapping
    public List<Task> getAll(@PathVariable Long accountId) {
        return taskService.getTasksByAccountId(accountId);
    }

    @GetMapping("/{taskId}")
    public Task getById(@PathVariable Long taskId) {
        return taskService.getTaskById(taskId);
    }

    @PutMapping("/{taskId}")
    public Task update(@PathVariable Long taskId, @Valid @RequestBody Task task) {
        return taskService.updateTask(taskId, task);
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> delete(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{taskId}/reassign")
    public Task reassignTask(@PathVariable Long taskId, @RequestParam Long newAccountId) {
        return taskService.reassignTask(taskId, newAccountId);
    }
}