package com.byakuya.leetcode.solution;

import java.util.LinkedList;

/**
 * 给定两个字符串 s 和 t 。返回 s 中包含 t 的所有字符的最短子字符串。如果 s 中不存在符合条件的子字符串，则返回空字符串 "" 。
 * 如果 s 中存在多个符合条件的子字符串，返回任意一个。
 * 注意： 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 1 <= s.length, t.length <= 105
 * s 和 t 由英文字母组成
 */
public class MinWindowSubString {
    public String solution(String s, String t) {
        int sl = s.length(), tl = t.length();
        if (sl == 0 || tl == 0 || tl > sl) return "";
        int[] marks = new int[128], reals = new int[128], tmp;
        int charCount = 0, markCount, realCount, currLen, minLen = Integer.MAX_VALUE, start = 0, end = 0;
        for (int i = 0, charIndex; i < tl; i++) {
            charIndex = t.charAt(i);
            marks[charIndex] += 1;
            if (marks[charIndex] == 1) {
                charCount++;
            }
        }
        LinkedList<int[]> linkedList = new LinkedList<>();
        for (int i = 0, charIndex; i < sl; i++) {
            charIndex = s.charAt(i);
            markCount = marks[charIndex];
            if (markCount == 0) continue;
            linkedList.addLast(new int[]{charIndex, i});
            realCount = ++reals[charIndex];
            if (realCount == markCount) {
                charCount--;
            }
            if (charCount == 0) {
                while (!linkedList.isEmpty()) {
                    tmp = linkedList.peekFirst();
                    charIndex = tmp[0];
                    if (reals[charIndex] > marks[charIndex]) {
                        linkedList.pollFirst();
                        reals[charIndex] -= 1;
                    } else {
                        currLen = i - tmp[1] + 1;
                        if (currLen < minLen) {
                            minLen = currLen;
                            start = tmp[1];
                            end = i;
                        }
                        break;
                    }
                }
            }
        }
        return charCount == 0 ? s.substring(start, end + 1) : "";
    }
}
