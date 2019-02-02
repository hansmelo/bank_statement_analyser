package com.monsterend;


import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class BankTransactionAnalyzerSimple {

    public static final String RESOURCES = "bank.csv";

    public static void main(String[] args) throws IOException, URISyntaxException {

        Path path = Paths.get(ClassLoader.getSystemResource(RESOURCES).toURI());
        List<String> lines = Files.readAllLines(path);
        double total = 0;
        for (String line : lines) {
            String[] columns = line.split(",");
            double amount = Double.parseDouble(columns[1]);
            total += amount;
        }

        System.out.println("The total for all transactions is " + total);
    }
}
