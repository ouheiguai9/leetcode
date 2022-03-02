package com.byakuya.leetcode.solution;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ganzl
 * @date 2022/2/24 17:33
 * 字符串无重排列
 */
public class StringArrange {
    public static void main(String[] args) {
        String str = "abcdefg";
        solution(str);
    }

    private static String[] solution(String s) {
        int len = s.length();
        if (len == 0 || len > 9) throw new IllegalArgumentException();
        String[] rtnVal = new String[cResultLen(len)];
        int start = cStart(len), end = cEnd(len), rtnValIndex = 0;
        char[] buff = new char[len];
        Set<Integer> flag = new HashSet<>(len);
        int tmp, charIndex, buffIndex;
        for (int i = start; i <= end; i++) {
            tmp = i;
            buffIndex = 0;
            flag.clear();
            while (tmp > 0) {
                charIndex = tmp % 10;
                if (charIndex > len || charIndex < 1) break;
                if (flag.contains(charIndex)) break;
                flag.add(charIndex);
                buff[buffIndex++] = s.charAt(charIndex - 1);
                tmp /= 10;
            }
            if (buffIndex == len) {
                rtnVal[rtnValIndex++] = new String(buff);
            }
        }
        return rtnVal;
    }

    private static int cEnd(int len) {
        int rtnVal = 0;
        for (int i = len; i >= 1; i--) {
            rtnVal = rtnVal * 10 + i;
        }
        return rtnVal;
    }

    private static int cStart(int len) {
        int rtnVal = 0;
        for (int i = 1; i <= len; i++) {
            rtnVal = rtnVal * 10 + i;
        }
        return rtnVal;
    }

    private static int cResultLen(int len) {
        int rtnVal = 1;
        for (int i = 2; i <= len; i++) {
            rtnVal *= i;
        }
        return rtnVal;
    }

//    private static int cMaxInterval(int mode, int buffIndex) {
//
//    }
}
