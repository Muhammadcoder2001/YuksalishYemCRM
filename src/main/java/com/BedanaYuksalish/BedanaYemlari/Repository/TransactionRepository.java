package com.BedanaYuksalish.BedanaYemlari.Repository;

import com.BedanaYuksalish.BedanaYemlari.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
