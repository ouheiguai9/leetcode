package com.byakuya.leetcode.solution;

import java.util.Stack;

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * 1 <= s.length <= 20
 * 1 <= p.length <= 30
 * s 只包含从 a-z 的小写字母。
 * p 只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 保证每次出现字符 * 时，前面都匹配到有效的字符
 */
public class RegMatchString {
    public static void main(String[] args) {
        solution("aaa", "ab*b*c*a");
    }

    public static boolean solution(String s, String p) {
        int sl = s.length();
        int pl = p.length();
        if (sl == 0 && pl == 0) return true;
        if (sl > 0 && pl == 0) return false;
        if (p.equals(".*")) return true;
        byte[] pre = new byte[pl];
        byte count = 0;
        for (int i = 0, j = -1; i < pl; i++) {
            if (p.charAt(i) == '*') {
                --count;
                if (j != -1 && count == pre[j]) {
                    if (p.charAt(i - 1) == '.' || p.charAt(i - 1) == p.charAt(j - 1)) {
                        pre[j] = -1;
                    } else if (p.charAt(j - 1) == '.') {
                        pre[i] = -1;
                        continue;
                    }
                }
                j = i;
                pre[i] = count;
            } else {
                count++;
            }
        }

        int sIndex = sl - 1, pIndex = pl - 1;
        char pc;
        Stack<int[]> cache = new Stack<>();
        while (pIndex > -1) {
            pc = p.charAt(pIndex);
            if (pc == '*') {
                count = pre[pIndex];
                if (sIndex + 1 < count) {
                    return false;
                }
                pIndex -= 2;
                if (count == -1 || sIndex < 0) {
                    continue;
                }
                pc = p.charAt(pIndex + 1);
                int counter = 0;
                if (pc == '.') {
                    counter = sIndex - count + 1;
                    sIndex = count - 1;
                } else {
                    while (sIndex + 1 > count && pc == s.charAt(sIndex)) {
                        sIndex--;
                        counter++;
                    }
                }
                if (counter > 0) {
                    cache.push(new int[]{pIndex, sIndex + counter, counter});
                }
            } else {
                if (sIndex < 0 || (pc != '.' && pc != s.charAt(sIndex))) {
                    if (!cache.isEmpty()) {
                        int[] tmp = cache.peek();
                        pIndex = tmp[0];
                        sIndex = tmp[1] - (--tmp[2]);
                        if (tmp[2] == 0) {
                            cache.pop();
                        }
                    } else {
                        return false;
                    }
                } else {
                    sIndex--;
                    pIndex--;
                }
            }
        }
        return sIndex < 0;
    }
}
