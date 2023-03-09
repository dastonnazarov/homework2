package atto.service;

import atto.container.ComponentContainer;
import atto.dto.Transaction;

public class TransactionService {


    public void addTransaction(Transaction transaction) {
        if (transaction != null) {
            ComponentContainer.transactionRepository.saveTransaction(transaction);
        } else System.err.println("error!!!!!!!!!!");
    }
}
