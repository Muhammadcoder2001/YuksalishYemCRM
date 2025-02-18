package com.BedanaYuksalish.BedanaYemlari.Controller;

import com.BedanaYuksalish.BedanaYemlari.Entity.Transaction;
import com.BedanaYuksalish.BedanaYemlari.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TransactionController {

    @Autowired
    private TransactionService service;

    @PostMapping("/transactions")
    public ResponseEntity<?> addProduct(@RequestBody Transaction transaction) {

        Transaction result = service.save(transaction);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/transactions")
    public ResponseEntity<?> updateProduct(@RequestBody Transaction transaction) {
        if (transaction.getId() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Transaction result = service.update(transaction);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/transactions")
    public ResponseEntity<?> getAllProducts() {
        List<Transaction> products = service.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/transactions/{id}")
    public ResponseEntity<?> getProduct(@PathVariable Long id) {
        Transaction result = service.getById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/transactions/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else
            service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
