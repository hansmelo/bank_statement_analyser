package com.monsterend.processor;

import com.monsterend.domain.BankTransaction;

public interface BankTransactionFilter {
    boolean test(BankTransaction bankTransaction);
}
