package com.dev.java8inactionbook.chap01;

import com.dev.java8inactionbook.pojo.Currency;
import com.dev.java8inactionbook.pojo.Transaction;
import org.junit.Test;

import java.util.*;

public class Test02Stream {

    @Test
    public void test01() {
        List<Transaction> transactions = Arrays.asList(new Transaction(200, new Currency("RMB")),
                new Transaction(180, new Currency("USD")),
                new Transaction(190, new Currency("USD")),
                new Transaction(220, new Currency("USD")),
                new Transaction(100, new Currency("RMB")));
        // old
        HashMap<Currency, List<Transaction>> transactionsByCurrencies = new HashMap<>();
        for (Transaction transaction : transactions) {
            if (transaction.getPrice() > 150) {
                Currency currency = transaction.getCurrency();
                List<Transaction> transactionsForCurrency = transactionsByCurrencies.get(currency);
                if (transactionsForCurrency == null) {
                    transactionsForCurrency = new ArrayList<>();
                    transactionsByCurrencies.put(currency,transactionsForCurrency);
                }
                transactionsForCurrency.add(transaction);
            }
        }

        Set<Map.Entry<Currency, List<Transaction>>> entries = transactionsByCurrencies.entrySet();
        for (Map.Entry<Currency, List<Transaction>> entry : entries) {
            Currency curr = entry.getKey();
            System.out.println("curr = " + curr);
            List<Transaction> listTrans = entry.getValue();
            for (Transaction listTran : listTrans) {
                System.out.println("listTran = " + listTran);
            }
        }
    }


    @Test
    public void test02() {
        //
        List<Transaction> transactions = Arrays.asList(new Transaction(200, new Currency("RMB")),
                new Transaction(180, new Currency("USD")),
                new Transaction(190, new Currency("USD")),
                new Transaction(220, new Currency("RMB")),
                new Transaction(100, new Currency("RMB")));
        // java8
//        transactions.stream()
//                .filter(transaction -> transaction.getPrice() > 100)
//                .collect(Transaction::getCurrency)
    }
}
