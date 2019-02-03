package com.monsterend.processor;

import com.monsterend.domain.BankTransaction;
import java.time.Month;
import java.util.List;
import static java.util.stream.Collectors.toList;

public class BankStatementProcessor {

    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public double calculateTotalAmount() {
        return summarizeTransactions(BankTransaction::getAmount);
    }

    public double calculateTotalInMonth(Month month) {
        return summarizeTransactions(bankTransaction ->
                month.equals(bankTransaction.getDate().getMonth()) ? bankTransaction.getAmount() : 0);
    }

    public double calculateTotalForCategory(String category) {
        return summarizeTransactions(bankTransaction ->
                category.equals(bankTransaction.getDescription()) ? bankTransaction.getAmount() : 0);
    }

    public List<BankTransaction> findTransactionsLesserThan(int amount) {
        return findTransaction(bankTransaction -> bankTransaction.getAmount() < amount);
    }

    public List<BankTransaction> findTransactionsEqualOrGreatherThanAndMonth(int amount, Month month) {
        return findTransaction(bankTransaction -> month.equals(bankTransaction.getDate().getMonth()) && bankTransaction.getAmount() >= amount);
    }


    public List<BankTransaction> findTransactionsNonMonth( Month month) {
        return findTransaction(bankTransaction -> !month.equals(bankTransaction.getDate().getMonth()));
    }

    private double summarizeTransactions(BankTransactionSummarizer bankTransactionSummarizer) {
        return bankTransactions.stream()
                .mapToDouble(bankTransactionSummarizer::summarize)
                .sum();
    }

    private List<BankTransaction> findTransaction(BankTransactionFilter bankTransactionFilter) {
        return bankTransactions.stream()
                .filter(bankTransactionFilter::test)
                .collect(toList());
    }
}
