package com.example.bank.service;

import com.example.bank.model.Account;
import com.example.bank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankService {

    @Autowired
    private AccountRepository repo;

    public Account create(Account acc) {
        return repo.save(acc);
    }

    public Account get(int id) {
        return repo.findById(id).orElse(null);
    }

    @Transactional
    public void transferMoney(int from, int to, double amount) {

        Account sender = repo.findById(from).orElseThrow();
        Account receiver = repo.findById(to).orElseThrow();

        sender.setBalance(sender.getBalance() - amount);

        if (true) {
            throw new RuntimeException("Test rollback");
        }

        receiver.setBalance(receiver.getBalance() + amount);

        repo.save(sender);
        repo.save(receiver);
    }
}