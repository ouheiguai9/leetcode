package com.byakuya.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author 田伯光
 * @createTime 2022/4/7 15:24
 * @description ValidParentheses
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 */
public class ValidParentheses {
    public static void main(String[] args) {
        String[] strArr = new String[]{"()", "()[]{}", "(]", "([)]", "{[]}"};
        for (String str : strArr) {
            System.out.print(str);
            System.out.print("\t");
            System.out.println(solution(str));
        }

    }

    private static boolean solution(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : chars) {
            switch (c) {
                case '{':
                case '[':
                case '(':
                    deque.push(c);
                    break;
                default:
                    if (deque.isEmpty() || !match(deque.pop(), c)) return false;
            }
        }
        return deque.isEmpty();
    }

    private static boolean match(char l, char r) {
        switch (l) {
            case '{':
                return '}' == r;
            case '[':
                return ']' == r;
            case '(':
                return ')' == r;
            default:
                return false;
        }
    }
}
