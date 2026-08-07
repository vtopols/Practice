package org.example.taskmanager.service;

import org.example.taskmanager.model.Account;
import org.example.taskmanager.repository.AccountRepository;
import org.example.taskmanager.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAllWithTasks();
    }

    public Account getAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with id: " + id));
    }

    public Account updateAccount(Long id, Account accountDetails) {
        Account existing = getAccountById(id);
        existing.setName(accountDetails.getName());
        existing.setSurname(accountDetails.getSurname());
        existing.setAge(accountDetails.getAge());
        return accountRepository.save(existing);
    }

    public void deleteAccount(Long id) {
        getAccountById(id);
        accountRepository.deleteById(id);
    }
}