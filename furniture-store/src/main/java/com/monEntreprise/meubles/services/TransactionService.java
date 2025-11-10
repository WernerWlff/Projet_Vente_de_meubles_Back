package com.monEntreprise.meubles.services;

import com.monEntreprise.meubles.entities.Furniture;
import com.monEntreprise.meubles.entities.Transaction;
import com.monEntreprise.meubles.entities.User;
import com.monEntreprise.meubles.repositories.FurnitureRepository;
import com.monEntreprise.meubles.repositories.TransactionRepository;
import com.monEntreprise.meubles.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final FurnitureRepository furnitureRepository;
    private final UserRepository userRepository;

    public TransactionService(TransactionRepository transactionRepository, FurnitureRepository furnitureRepository, UserRepository userRepository) {
        this.transactionRepository = transactionRepository;
        this.furnitureRepository = furnitureRepository;
        this.userRepository = userRepository;
    }

    public List<Transaction> getAllTransactions(){
        return transactionRepository.findAll();
    }

    public Optional<Transaction> getTransactionById(Long id){
        return transactionRepository.findById(id);
    }

    @Transactional
    public Transaction createTransaction(Transaction transaction) {
        Long furnitureId = transaction.getFurniture().getId();
        Optional<Furniture> furnitureOptional = furnitureRepository.findById(furnitureId);
        if (furnitureOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Furniture furniture = furnitureOptional.get();

        Long userId = transaction.getUser().getId();
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        User user = userOptional.get();

        transaction.setFurniture(furniture);
        transaction.setUser(user);
        return transactionRepository.save(transaction);
    }

    @Transactional
    public Optional<Transaction> updateTransaction(Long id, Transaction transactionDetails){
        Optional<Transaction> optionalTransaction = transactionRepository.findById(id);

        if (optionalTransaction.isPresent()){
            Transaction existingTransaction = optionalTransaction.get();
            existingTransaction.setSold_at(transactionDetails.getSold_at());
            Transaction updatedTransaction = transactionRepository.save(existingTransaction);
            return Optional.of(updatedTransaction);
        }
        return Optional.empty();
    }

    @Transactional
    public Optional<Transaction> deleteTransaction(Long id){
        Optional<Transaction> transaction = transactionRepository.findById(id);

        if (transaction.isPresent()){
            transactionRepository.delete(transaction.get());
        }
        return transaction;
    }
}
