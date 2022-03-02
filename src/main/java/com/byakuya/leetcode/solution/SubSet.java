package com.byakuya.leetcode.solution;

import java.util.*;

/**
 * @author ganzl
 * @date 2022/3/1 17:18
 * 数组无重复子集问题
 */
public class SubSet {
    public static void main(String[] args) {
        int[] candidates = new int[]{3, 2, 1, 1, 4};
        int target = 6;
        solution(candidates, target).forEach(list -> System.out.println(Arrays.toString(list.toArray(new Integer[0]))));
    }

    private static List<List<Integer>> solution(int[] candidates, int target) {
        Arrays.sort(candidates);
        int len = candidates.length, candidateLen = 1 << len;
        Set<String> repeat = new HashSet<>();
        List<List<Integer>> rtnVal = new ArrayList<>();
        for (int i = 1; i < candidateLen; i++) {
            List<Integer> sub = new ArrayList<>();
            int sum = target;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < len; j++) {
                if ((i & (1 << j)) > 0) {
                    int tmp = candidates[j];
                    sum -= tmp;
                    if (sum < 0) break;
                    sub.add(tmp);
                    sb.append('|').append(tmp);
                }
            }
            if (sum == 0) {
                String str = sb.toString();
                if (!repeat.contains(str)) {
                    rtnVal.add(sub);
                    repeat.add(str);
                }
            }
        }
        return rtnVal;
    }
}
