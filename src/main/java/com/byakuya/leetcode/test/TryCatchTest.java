package com.byakuya.leetcode.test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.function.Consumer;

/**
 * @author ganzl
 * @date 2022/3/14 11:12
 */
public class TryCatchTest {
    public static void main(String[] args) {
        for (int iter = 0; iter < 20; iter++) {
            final int y = iter;
            timing("no try catch", i -> method(y));
            timing("try catch", i -> {
                try {
                    method(y);
                } catch (RuntimeException e) {
                    // todo
                }
            });
        }

    }

    private static void method(Integer i) {
        if (i == 0) return;
        method(i - 1);
    }

    private static void timing(String msg, Consumer<Integer> action) {
        LocalDateTime start = LocalDateTime.now();
        for (int i = 0; i < 100000000; i++) {
            action.accept(i);
        }
        LocalDateTime end = LocalDateTime.now();
        System.out.println(msg + ": " + Duration.between(start, end).toMillis() + "毫秒");
    }
}
