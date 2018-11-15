package com.dev.java8inactionbook.pojo;

import lombok.Data;

@Data
public class Apple {
    private String color;
    private int weight;

    public Apple(int weight, String color) {
        this.color = color;
        this.weight = weight;
    }

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }
}
