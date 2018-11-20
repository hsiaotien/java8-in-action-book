package com.dev.java8inactionbook.chap02;

import com.dev.java8inactionbook.pojo.Apple;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test01ToBegin {

    /**
     * 01.初试牛刀
     * @param inventory
     * @return
     */
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        ArrayList<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }


    /**
     * 02.把颜色作为参数，灵活适应变化
     * @param inventory
     * @param color
     * @return
     */
    public static List<Apple> filterGreenByColor(List<Apple> inventory, String color) {
        ArrayList<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getColor().equals(color)) {
                result.add(apple);
            }
        }
        return result;
    }



    @Test
    public void test01() {
        List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"));
        //
        List<Apple> greenApples = filterGreenByColor(inventory, "green");
        greenApples.forEach(System.out::println);
    }

    /**
     * 根据重量过滤苹果
     * @param inventory
     * @param weight
     * @return
     */
    public static List<Apple> filterGreenByWeight(List<Apple> inventory, int weight) {
        ArrayList<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > weight) {
                result.add(apple);
            }
        }
        return result;
    }




}
