package org.example.taskmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/accounts/{accountId}/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> create(@PathVariable Long accountId, @Valid @RequestBody Task task) {
        return new ResponseEntity<>(taskService.createTask(accountId, task), HttpStatus.CREATED);
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
    public ResponseEntity<Task> reassignTask(@PathVariable Long taskId, @RequestParam Long newAccountId) {
        Task reassignedTask = taskService.reassignTask(taskId, newAccountId);
        return ResponseEntity.ok(reassignedTask);
    }
}