package com.dev.java8inactionbook.util;

import com.dev.java8inactionbook.pojo.Apple;

import java.util.ArrayList;
import java.util.List;

public interface AppleFilterUtils {

    /**
     * 注意，java8已经提供了一系列这种类似的函数式接口（这里类似定义）
     * @param <T>
     */
    interface IPredicate<T> {
        boolean test(T t);
    }

    static List<Apple> filterApples(List<Apple> inventory, IPredicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}
