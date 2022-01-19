package com.byakuya.leetcode.sort;

import java.util.Arrays;

/**
 * @author ganzl
 * @date 2022/1/5 17:02
 */
public class HeapSort {
    /**
     * 向下调整
     *
     * @param arr   目标数组
     * @param start 开始下标
     * @param end   结束下标
     * @param index 当前下标
     */
    private static void downwardAdjust(int[] arr, int start, int end, int index) {
        if (index < start && index > end) return;
        int leftIndex = 2 * index + 1, rightIndex = leftIndex + 1, nextIndex = index;
        if (rightIndex <= end && arr[rightIndex] > arr[nextIndex]) {
            nextIndex = rightIndex;
        }
        if (leftIndex <= end && arr[leftIndex] > arr[nextIndex]) {
            nextIndex = leftIndex;
        }
        if (nextIndex != index) {
            swap(arr, index, nextIndex);
            downwardAdjust(arr, start, end, nextIndex);
        }
    }

    public static void main(String[] args) {
        int[] target = new int[]{4, 7, 4, 3, 2, 5, 6, 1, 9, 0};
        sort(target, 0, target.length - 1);
        System.out.println(Arrays.toString(target));
    }

    private static void sort(int[] arr, int start, int end) {
        int length = end - start + 1;
        for (int i = length / 2 - 1 + start; i >= start; i--) {
            downwardAdjust(arr, start, end, i);
        }
        while (start < end) {
            swap(arr, start, end--);
            downwardAdjust(arr, start, end, start);
        }
    }

    private static void swap(int[] arr, int posX, int posY) {
        int tmp = arr[posX];
        arr[posX] = arr[posY];
        arr[posY] = tmp;
    }
}
