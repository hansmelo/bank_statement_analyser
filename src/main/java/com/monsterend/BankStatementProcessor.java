package com.monsterend;

import com.monsterend.domain.BankTransaction;

import java.time.Month;
import java.util.List;

public class BankStatementProcessor {

    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public double calculateTotalAmount() {
        return bankTransactions.stream()
                .mapToDouble(BankTransaction::getAmount)
                .sum();
    }

    public double calculateTotalInMonth(Month month) {
        return bankTransactions.stream()
                .filter(bankTransaction -> month.equals(bankTransaction.getDate().getMonth()))
                .mapToDouble(BankTransaction::getAmount)
                .sum();
    }

    public double calculateTotalForCategory(String category) {
        return bankTransactions.stream()
                .filter(bankTransaction -> category.equals(bankTransaction.getDescription()))
                .mapToDouble(BankTransaction::getAmount)
                .sum();
    }
}
