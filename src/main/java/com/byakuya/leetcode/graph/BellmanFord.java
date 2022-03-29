package com.byakuya.leetcode.graph;

import java.util.Arrays;

/**
 * 贝尔曼-福特算法
 *
 * @author ganzl
 * @date 2022/3/28 16:53
 */
public class BellmanFord {
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
        System.out.println(Arrays.toString(algorithm(graph, max)));
    }

    private static int[] algorithm(int[][] graph, int max) {
        int n = graph.length;
        int[] weights = graph[0].clone();
        int iter = n - 2;
        while (iter > 0) {
            if (!traverse(graph, weights, max)) {
                break;
            }
            iter--;
        }
        if (iter == 0 && traverse(graph, weights.clone(), max)) {
            throw new RuntimeException("存在负循环");
        }
        return weights;
    }

    private static boolean traverse(int[][] graph, int[] weights, int max) {
        int n = graph.length;
        boolean success = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp;
                if (i == j || (tmp = graph[i][j]) == max) {
                    continue;
                }
                if (weights[i] + tmp < weights[j]) {
                    weights[j] = weights[i] + tmp;
                    success = true;
                }
            }
        }
        return success;
    }
}
