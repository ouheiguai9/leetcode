package com.byakuya.leetcode.sort;

import java.util.Arrays;

/**
 * @author ganzl
 * @date 2021/12/28 16:10
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] target = new int[]{4, 7, 4, 3, 2, 5, 6, 1, 9, 0};
        sort(target, 0, target.length - 1);
        System.out.println(Arrays.toString(target));
    }

    private static void sort(int[] arr, int start, int end) {
        boolean hasChange = true;
        for (int i = 0; i < end && hasChange; i++) {
            hasChange = false;
            for (int j = 0; j < end - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    hasChange = true;
                    swap(arr, j, j + 1);
                }

            }
        }
    }

    private static void swap(int[] arr, int posX, int posY) {
        int tmp = arr[posX];
        arr[posX] = arr[posY];
        arr[posY] = tmp;
    }
}
