package com.dev.java8inactionbook.chap01;

import com.dev.java8inactionbook.pojo.Apple;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Test03Thread {

    /**
     * 顺序处理
     */
    @Test
    public void test01() {
        List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"));
       //
        List<Apple> list = inventory.stream()
                .filter(apple -> apple.getWeight() > 150)
                .collect(toList());
        list.forEach(System.out::println);
    }

    /**
     * 并行处理
     */
    @Test
    public void test02() {
        List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"));
       //
        List<Apple> list = inventory.parallelStream()
                .filter(apple -> apple.getWeight() > 150)
                .collect(toList());
        list.forEach(System.out::println);
    }
}
