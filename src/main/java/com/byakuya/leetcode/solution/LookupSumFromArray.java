package com.byakuya.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 从数组中找到sum等于target的所有集合
 */
public class LookupSumFromArray {
    public static void main(String[] args) {
        int[] candidates = new int[]{1, 1, 1, 1, 1, 2, 2, 2, 1, 2, 6, 7, 4, 4, 3, 3, 5, 5};
        int target = 10;
        solution(candidates, target).forEach(list -> System.out.println(Arrays.toString(list.toArray(new Integer[0]))));
    }

    private static List<List<Integer>> solution(int[] candidates, int target) {
        List<List<Integer>> rtnVal = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> repeatList = computeRepeat(candidates, excludeInvalidNum(candidates, target, rtnVal));
        int len = repeatList.size();
        for (int i = 0; i < len; i++) {
            compute(candidates, target, len, repeatList, i, 0, new ArrayList<>(), rtnVal);
        }
        return rtnVal;
    }

    private static void compute(int[] candidates, int target, int len, List<Integer> repeatList, int start, int sum, List<Integer> prefix, List<List<Integer>> result) {
        int repeat = repeatList.get(start), candidate = candidates[start++];
        for (int i = 0; i < repeat; i++) {
            sum += candidate;
            prefix.add(candidate);
            if (sum < target && start < len) {
                for (int j = start; j < len; j++) {
                    compute(candidates, target, len, repeatList, j, sum, new ArrayList<>(prefix), result);
                }
            } else {
                if (sum < target) continue;
                if (sum == target) {
                    result.add(prefix);
                }
                return;
            }
        }
    }

    private static int excludeInvalidNum(int[] candidates, int target, List<List<Integer>> result) {
        int len = candidates.length;
        int i = len - 1;
        while (i > -1) {
            if (target > candidates[i]) {
                len = i + 1;
                if (len < candidates.length && candidates[len] == target) {
                    result.add(Collections.singletonList(candidates[len]));
                }
                break;
            }
            i--;
        }
        return len;
    }

    private static List<Integer> computeRepeat(int[] candidates, int len) {
        List<Integer> rtnVal = new ArrayList<>();
        int lastIndex = 0, last = candidates[lastIndex];
        for (int i = 1; i < len; i++) {
            int current = candidates[i];
            if (last != current) {
                candidates[rtnVal.size()] = last;
                rtnVal.add(i - lastIndex);
                lastIndex = i;
                last = candidates[lastIndex];
            }
        }
        candidates[rtnVal.size()] = last;
        rtnVal.add(len - lastIndex);
        return rtnVal;
    }
}
