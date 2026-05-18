package org.example.taskmanager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query("SELECT DISTINCT a FROM Account a LEFT JOIN FETCH a.tasks")
    List<Account> findAllWithTasks();
}
