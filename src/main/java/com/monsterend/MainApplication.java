package com.monsterend;

import com.monsterend.analyzer.BankTransactionAnalyzer;
import com.monsterend.parser.BankStatementCSVParser;
import com.monsterend.parser.BankStatementParser;

import java.io.IOException;
import java.net.URISyntaxException;

public class MainApplication {

    public static void main(String[] args) throws IOException, URISyntaxException {
        BankTransactionAnalyzer bankTransactionAnalyzer = new BankTransactionAnalyzer();
        BankStatementParser bankStatementParser = new BankStatementCSVParser();

        bankTransactionAnalyzer.analyze(bankStatementParser);
    }
}
