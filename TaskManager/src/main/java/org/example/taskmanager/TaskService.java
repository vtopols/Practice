package org.example.taskmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AccountService accountService;

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
            throw new RuntimeException("Задача уже привязана к этому аккаунту");
        }

        task.setAccount(newAccount);
        return taskRepository.save(task);
    }
}