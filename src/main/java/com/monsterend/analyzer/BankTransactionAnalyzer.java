package com.monsterend.analyzer;


import com.monsterend.domain.BankTransaction;
import com.monsterend.parser.BankStatementCSVParser;
import com.monsterend.parser.BankStatementParser;
import com.monsterend.processor.BankStatementProcessor;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankTransactionAnalyzer {

    public static final String RESOURCES = "bank.csv";

    public void analyze(BankStatementParser bankStatementParser) throws IOException, URISyntaxException {
        Path path = Paths.get(ClassLoader.getSystemResource(RESOURCES).toURI());
        List<String> lines = Files.readAllLines(path);

        List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
        BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        collectSummary(bankStatementProcessor);
    }

    private static void collectSummary(BankStatementProcessor bankStatementProcessor) {
        System.out.println("The total for all transactions is "
                + bankStatementProcessor.calculateTotalAmount());

        System.out.println("The total for transactions in January is "
                + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));

        System.out.println("The total for transactions in February is "
                + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));

        System.out.println("The total salary received is "
                + bankStatementProcessor.calculateTotalForCategory("Salary"));

        System.out.println("The transactions of February and equal or bigger than 1_000 "
                + bankStatementProcessor.findTransaction(bankTransaction ->
                bankTransaction.getDate().getMonth() == Month.FEBRUARY &&
                bankTransaction.getAmount() >= 1_000));

        System.out.println("non-February transactions "
                + bankStatementProcessor.findTransaction(bankTransaction ->
                bankTransaction.getDate().getMonth() != Month.FEBRUARY));

        System.out.println("The outcomes "
                + bankStatementProcessor.findTransaction(bankTransaction ->
                bankTransaction.getAmount() < 0));
    }

}
