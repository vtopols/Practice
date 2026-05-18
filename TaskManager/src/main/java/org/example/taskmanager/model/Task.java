package org.example.taskmanager;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Название задачи не может быть пустым")
    @Column(nullable = false)
    private String title;

    @Column(length = 1000)
    private String body;

    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    @JsonBackReference
    private Account account;

    public Task() {}

    public Task(String title, String body, boolean completed, Account account) {
        this.title = title;
        this.body = body;
        this.completed = completed;
        this.account = account;
    }

    // Геттеры и сеттеры
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getBody() { return body; }
    public void setBody(String body) { this.body = body; }

    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }

    public Account getAccount() { return account; }
    public void setAccount(Account account) { this.account = account; }
}
