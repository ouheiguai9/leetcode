package com.byakuya.leetcode.graph;

import java.util.Arrays;

/**
 * 迪克斯特拉算法
 *
 * @author ganzl
 * @date 2022/3/28 14:07
 */
public class Dijkstra {
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
        System.out.println(Arrays.toString(algorithm(graph)));
    }

    private static int[] algorithm(int[][] graph) {
        int n = graph.length;
        int[] nodes = new int[n], weights = Arrays.copyOf(graph[0], n);
        for (int i = 0; i < n; i++) {
            nodes[i] = i;
        }
        int visited = 1;
        while (visited < n) {
            int minIndex = visited, minWeight = weights[visited], j;
            for (int i = visited + 1; i < n; i++) {
                if (weights[nodes[i]] < minWeight) {
                    minWeight = weights[nodes[i]];
                    minIndex = i;
                }
            }
            if (visited != minIndex) {
                int tmp = nodes[minIndex];
                nodes[minIndex] = nodes[visited];
                nodes[visited] = tmp;
            }
            j = nodes[visited];
            visited++;
            for (int i = visited; i < n; i++) {
                int tmp = graph[j][nodes[i]] + weights[j];
                if (tmp < weights[nodes[i]]) {
                    weights[nodes[i]] = tmp;
                }
            }
        }
        return weights;
    }
}
