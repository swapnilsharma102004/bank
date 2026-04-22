package com.example.bank.controller;

import com.example.bank.model.Account;
import com.example.bank.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank")
public class BankController {

    @Autowired
    private BankService service;

    @PostMapping("/create")
    public Account create(@RequestBody Account acc) {
        return service.create(acc);
    }

    @GetMapping("/{id}")
    public Account get(@PathVariable int id) {
        return service.get(id);
    }

    @PostMapping("/transfer")
    public String transfer(@RequestParam int from,
            @RequestParam int to,
            @RequestParam double amount) {

        service.transferMoney(from, to, amount);
        return "Transfer Successful";
    }
}