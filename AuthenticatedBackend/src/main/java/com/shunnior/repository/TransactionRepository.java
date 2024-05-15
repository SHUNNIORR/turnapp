package com.shunnior.repository;

import com.shunnior.models.Transaction;
import com.shunnior.utils.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Optional<List<Transaction>> findByTransactionType(TransactionType transactionType);

    //funcion que me trae las transacciones por el account ID

    Optional<List<Transaction>> findBySourceAccount_accountIdOrTargetAccount_accountId(Long sourceAccountId, Long targetAccountId);
}
