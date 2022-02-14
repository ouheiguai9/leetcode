package com.byakuya.leetcode.string;

/**
 * @author ganzl
 * @date 2022/2/14 10:50
 */
public class Atoi {
    public static void main(String[] args) {
        String[] sampleArr = new String[]{"2147483648", "   ", "42", "   -42", "4193 with words", "words and 987", "-91283472332"};
        for (String s : sampleArr) {
            System.out.println(atoi(s));
        }
    }

    private static int atoi(String s) {
        if (s == null || s.length() == 0) return 0;
        int i = 0, n = s.length(), result = 0, sign = 1, limit = Integer.MAX_VALUE / 10;
        while (s.charAt(i) == ' ') {
            i++;
            if (i == n) return 0;
        }
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        for (; i < n; i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') break;
            //-2147483648到2147483647最后一位7
            if (result > limit || (result == limit && c > '7')) {
                return (sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE);
            }
            result = result * 10 + (c - '0');
        }
        return sign * result;
    }
}
