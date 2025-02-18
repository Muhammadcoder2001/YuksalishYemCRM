package com.BedanaYuksalish.BedanaYemlari.Service;

import com.BedanaYuksalish.BedanaYemlari.Entity.Transaction;
import com.BedanaYuksalish.BedanaYemlari.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repository;

    public Transaction save(Transaction transaction) {
        transaction.setDate(new Date(System.currentTimeMillis()));
        return repository.save(transaction);
    }

    public List<Transaction> findAll() {
        return repository.findAll();
    }

    public Transaction getById(Long id) {
        return repository.findById(id).get();
    }

    public Transaction update(Transaction transaction) {
        return repository.save(transaction);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
