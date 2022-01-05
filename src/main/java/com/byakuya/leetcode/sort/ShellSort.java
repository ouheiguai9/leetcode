package com.byakuya.leetcode.sort;

import java.util.Arrays;

/**
 * @author ganzl
 * @date 2021/12/28 16:35
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] target = new int[]{4, 7, 4, 3, 2, 5, 6, 1, 9, 0};
        sort(target, 0, target.length - 1);
        System.out.println(Arrays.toString(target));
    }

    private static void sort(int[] arr, int start, int end) {
        for (int gap = (end - start + 1) / 2; gap > 0; ) {
            for (int i = start + gap; i <= end; i++) {
                int key = arr[i];
                int j = i - gap;
                while (j >= start && key < arr[j]) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = key;
            }
            gap /= 2;
        }
    }
}
