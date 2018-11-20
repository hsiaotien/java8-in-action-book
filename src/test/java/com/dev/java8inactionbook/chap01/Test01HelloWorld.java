package com.dev.java8inactionbook.chap01;

import com.dev.java8inactionbook.pojo.Apple;
import com.dev.java8inactionbook.util.AppleFilterUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test01HelloWorld {

    /**
     * 初体验
     */
    @Test
    public void test01() {
        List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"));
        // old
        Collections.sort(inventory, new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight() - o2.getWeight();
            }
        });
        for (Apple apple : inventory) {
            System.out.println("apple = " + apple);
        }
        // java8
        System.out.println(" ==========java8语法================== ");
        inventory.sort(Comparator.comparing(Apple::getWeight));
        inventory.forEach(apple -> System.out.println("apple = " + apple));
    }

    @Test
    public void test02() {
        // old
        String path = ".";
        File[] hiddenFiles = new File(path).listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isHidden();
            }
        });
        for (File hiddenFile : hiddenFiles) {
            System.out.println("hiddenFile = " + hiddenFile);
        }
        // java8
        System.out.println(" ==========java8语法================== ");
        File[] listFiles = new File(path).listFiles(File::isHidden);
        for (File listFile : listFiles) {
            System.out.println("listFile = " + listFile);
        }
    }

    // 传递方法
    @Test
    public void test03() {
        List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"));
        //
        System.out.println(" green apple : ");
        List<Apple> listGreenApple = AppleFilterUtils.filterApples(inventory, Apple::isGreenApple);
        listGreenApple.forEach(System.out::println);
        //
        System.out.println(" green apple : ");
        List<Apple> heavyApple = AppleFilterUtils.filterApples(inventory, Apple::isHeavyApple);
        heavyApple.forEach(System.out::println);
    }

    // 匿名函数或者Lambda
    @Test
    public void test04() {
        List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"));
        //
        System.out.println(" green apple : ");
        List<Apple> listGreenApple = AppleFilterUtils.filterApples(inventory, apple -> "green".equals(apple.getColor()));
        listGreenApple.forEach(System.out::println);
        System.out.println(" green apple : ");
        List<Apple> listHeavyApple = AppleFilterUtils.filterApples(inventory, apple -> apple.getWeight() > 150);
        listHeavyApple.forEach(System.out::println);
        //
        System.out.println(" heavy or green apple : ");
        List<Apple> listApple = AppleFilterUtils.filterApples(inventory, apple -> apple.getWeight() > 150 || "green".equals(apple.getColor()));
        listApple.forEach(System.out::println);
    }
}
