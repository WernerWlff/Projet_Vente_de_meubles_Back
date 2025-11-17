package com.monEntreprise.meubles.controllers;

import com.monEntreprise.meubles.entities.Transaction;
import com.monEntreprise.meubles.services.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions(){
        return new ResponseEntity<>(transactionService.getAllTransactions(), HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable Long id){
        Optional<Transaction> transaction = transactionService.getTransactionById(id);

        if (transaction.isPresent()){
            return new ResponseEntity<>(transaction.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction){
        Transaction transactionCreated = transactionService.createTransaction(transaction);
        return new ResponseEntity<>(transactionCreated, HttpStatus.CREATED);
    }

    @PutMapping("/id")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable Long id, @RequestBody Transaction transactionDetails){
        Optional<Transaction> transaction = transactionService.updateTransaction(id, transactionDetails);

        if (transaction.isPresent()){
            return new ResponseEntity<>(transaction.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id){
        Optional<Transaction> deletedTransaction = transactionService.deleteTransaction(id);

        if (deletedTransaction.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
