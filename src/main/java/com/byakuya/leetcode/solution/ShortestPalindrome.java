package com.byakuya.leetcode.solution;

/**
 * 给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
 */
public class ShortestPalindrome {
    public String solution(String s) {
        if (s == null || "".equals(s)) return "";
        if (s.length() == 1) return s;
        int start = s.length() - 1, left = 0, right = start;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                left = 0;
                right = --start;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i > start; i--) {
            sb.append(s.charAt(i));
        }
        return sb.append(s).toString();
    }
}
