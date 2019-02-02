package com.monsterend;


import com.monsterend.domain.BankTransaction;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class BankTransactionAnalyzerSimple {

    public static final String RESOURCES = "bank.csv";

    public static void main(String[] args) throws IOException, URISyntaxException {
        BankStatementCSVParser bankStatementCSVParser = new BankStatementCSVParser();
        Path path = Paths.get(ClassLoader.getSystemResource(RESOURCES).toURI());
        List<String> lines = Files.readAllLines(path);

        List<BankTransaction> bankTransactions = bankStatementCSVParser.parseLinesFromCSV(lines);

        System.out.println("The total for all transactions is " + calculateTotalAmount(bankTransactions));
        System.out.println("Transactions in January " + selectInMonth(bankTransactions, Month.JANUARY));

    }

    private static double calculateTotalAmount(List<BankTransaction> bankTransactions) {
        return bankTransactions.stream().mapToDouble(BankTransaction::getAmount).sum();
    }

    private static List<BankTransaction> selectInMonth(List<BankTransaction> bankTransactions, Month month) {
        return bankTransactions.stream()
                .filter(bankTransaction -> month == bankTransaction.getDate().getMonth())
                .collect(toList());
    }

}
