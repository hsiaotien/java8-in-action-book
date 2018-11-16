package com.dev.java8inactionbook.pojo;

import lombok.Data;

@Data
public class Currency {
    private String name;

    public Currency() {
    }

    public Currency(String name) {
        this.name = name;
    }
}
