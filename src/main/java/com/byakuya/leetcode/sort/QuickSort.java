package com.byakuya.leetcode.sort;

import java.util.Arrays;

/**
 * @author ganzl
 * @date 2021/12/29 16:33
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] target = new int[]{4, 7, 4, 3, 2, 5, 6, 1, 9, 0};
        sort(target, 0, target.length - 1);
        System.out.println(Arrays.toString(target));
    }

    private static void sort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int i = start - 1, j = end + 1, key = arr[start];
        while (i < j) {
            while (arr[--j] > key) ;
            while (arr[++i] < key) ;
            if (i < j) {
                swap(arr, i, j);
            }
        }
        sort(arr, start, j);
        sort(arr, j + 1, end);
    }

    private static void swap(int[] arr, int posX, int posY) {
        int tmp = arr[posX];
        arr[posX] = arr[posY];
        arr[posY] = tmp;
    }
}
