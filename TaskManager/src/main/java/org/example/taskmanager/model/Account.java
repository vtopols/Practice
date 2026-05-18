package org.example.taskmanager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Имя не может быть пустым")
    @Size(max = 100, message = "Имя не может быть длиннее 100 символов")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Фамилия не может быть пустой")
    @Size(max = 100, message = "Фамилия не может быть длиннее 100 символов")
    @Column(nullable = false)
    private String surname;

    @PositiveOrZero(message = "Возраст не может быть отрицательным")
    private int age;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Task> tasks;

    public Account() {}

    public Account(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public List<Task> getTasks() { return tasks; }
    public void setTasks(List<Task> tasks) { this.tasks = tasks; }
}
