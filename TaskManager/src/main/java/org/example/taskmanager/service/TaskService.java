package org.example.taskmanager.service;

import org.example.taskmanager.model.Task;
import org.example.taskmanager.model.Account;
import org.example.taskmanager.repository.TaskRepository;
import org.example.taskmanager.exception.ResourceNotFoundException;
import org.example.taskmanager.exception.TaskAlreadyAssignedException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final AccountService accountService;

    public TaskService(TaskRepository taskRepository, AccountService accountService) {
        this.taskRepository = taskRepository;
        this.accountService = accountService;
    }

    public Task createTask(Long accountId, Task task) {
        Account account = accountService.getAccountById(accountId);
        task.setAccount(account);
        return taskRepository.save(task);
    }

    public List<Task> getTasksByAccountId(Long accountId) {
        accountService.getAccountById(accountId);
        return taskRepository.findByAccountId(accountId);
    }

    public Task getTaskById(Long taskId) {
        return taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + taskId));
    }

    public Task updateTask(Long taskId, Task taskDetails) {
        Task existing = getTaskById(taskId);
        existing.setTitle(taskDetails.getTitle());
        existing.setBody(taskDetails.getBody());
        existing.setCompleted(taskDetails.isCompleted());
        return taskRepository.save(existing);
    }

    public void deleteTask(Long taskId) {
        getTaskById(taskId);
        taskRepository.deleteById(taskId);
    }

    public Task reassignTask(Long taskId, Long newAccountId) {
        Task task = getTaskById(taskId);
        Account newAccount = accountService.getAccountById(newAccountId);

        if (task.getAccount().getId().equals(newAccountId)) {
            throw new TaskAlreadyAssignedException("Task with id " + taskId + " is already assigned to account with id " + newAccountId);
        }

        task.setAccount(newAccount);
        return taskRepository.save(task);
    }
}