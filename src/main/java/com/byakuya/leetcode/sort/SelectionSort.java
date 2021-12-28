package com.byakuya.leetcode.sort;

import java.util.Arrays;

/**
 * @author ganzl
 * @date 2021/12/28 17:06
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] target = new int[]{4, 7, 4, 3, 2, 5, 6, 1, 9, 0};
        sort(target, 0, target.length - 1);
        System.out.println(Arrays.toString(target));
    }

    private static void sort(int[] arr, int start, int end) {
        for (int i = start; i < end; i++) {
            int minIndex = i;
            for (int j = i + 1; j <= end; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
                swap(arr, i, minIndex);
            }
        }
    }

    private static void swap(int[] arr, int posX, int posY) {
        int tmp = arr[posX];
        arr[posX] = arr[posY];
        arr[posY] = tmp;
    }
}
