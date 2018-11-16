package com.dev.java8inactionbook.pojo;

import lombok.Data;


@Data
public class Transaction {
    private int price;
    private Currency currency;

    public Transaction() {
    }

    public Transaction(int price, Currency currency) {
        this.price = price;
        this.currency = currency;
    }
}
