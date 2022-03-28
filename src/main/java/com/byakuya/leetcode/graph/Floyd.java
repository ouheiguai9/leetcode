package com.byakuya.leetcode.graph;

import java.util.Arrays;

/**
 * 弗洛伊德算法
 *
 * @author ganzl
 * @date 2022/3/28 16:53
 */
public class Floyd {
    public static void main(String[] args) {
        int max = 99999999;
        int[][] graph = new int[][]{
                new int[]{0, 10, max, max, max, 3},
                new int[]{max, 0, 7, 5, max, max},
                new int[]{max, max, 0, max, max, max},
                new int[]{3, max, 4, 0, 7, max},
                new int[]{max, max, max, max, 0, max},
                new int[]{max, 2, max, 6, 1, 0}
        };
        int[][] weights = algorithm(graph);
        for (int[] weight : weights) {
            System.out.println(Arrays.toString(weight));
        }
    }

    private static int[][] algorithm(int[][] graph) {
        int n = graph.length;
        int[][] weights = new int[n][];
        for (int i = 0; i < n; i++) {
            weights[i] = Arrays.copyOf(graph[i], n);
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int tmp = weights[i][k] + weights[k][j];
                    if (tmp < weights[i][j]) {
                        weights[i][j] = tmp;
                    }
                }
            }
        }
        return weights;
    }
}
