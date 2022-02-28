package com.byakuya.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ganzl
 * @date 2022/2/25 17:02
 * 排列问题
 */
public class Permutation {
    public static void main(String[] args) {
        String str = "123";
        System.out.println(Arrays.toString(solution(str.toCharArray())));
    }

    private static void permutation(char[] chars, int start, int len, List<String> result) {
        for (int i = start; i < len; i++) {
            int next = start + 1;
            if (next == len) {
                result.add(String.valueOf(chars));
            } else {
                swap(chars, i, start);
                permutation(chars, next, len, result);
                swap(chars, i, start);
            }
        }
    }

    private static String[] solution(char[] chars) {
        List<String> rtnVal = new ArrayList<>();
        permutation(chars, 0, chars.length, rtnVal);
        return rtnVal.toArray(new String[0]);
    }

    private static void swap(char[] chars, int i, int j) {
        if (i == j) return;
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }
}
