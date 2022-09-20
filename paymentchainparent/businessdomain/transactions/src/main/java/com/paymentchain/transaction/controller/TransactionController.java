/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.paymentchain.transaction.controller;

import com.paymentchain.transaction.entities.Transaction;
import com.paymentchain.transaction.repository.TransactionRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Eduard Suárez
 */
@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    private TransactionRepository repository;
    
    @GetMapping()
    public List<Transaction> list() {
        return repository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Transaction> get(@PathVariable long id) {
    
        return repository.findById(id).map(x -> 
        ResponseEntity.ok(x)).orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/transactions")
    public List<Transaction> get(@RequestParam String ibanAccount) {
      return repository.findByIbanAccount(ibanAccount);      
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Transaction input) {
        return null;
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Transaction input) {
        Transaction transaction = repository.save(input);
        return ResponseEntity.ok(transaction);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return null;
    }
    
    
}
