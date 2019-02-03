package com.monsterend.processor;

import com.monsterend.domain.BankTransaction;

@FunctionalInterface
public interface BankTransactionSummarizer {
    double summarize(BankTransaction bankTransaction);
}
