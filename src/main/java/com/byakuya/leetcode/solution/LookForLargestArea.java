package com.byakuya.leetcode.solution;

import java.util.Arrays;

/**
 * 求大神指点
 */
public class LookForLargestArea {

    public int largestRectangleArea(int[] heights) {
        int length = heights.length;
        int[] heightNew = new int[length];
        for (int i = 0; i < length; i++) {
            heightNew[i] = heights[i];
        }
        Arrays.sort(heightNew);
        if(heightNew[0] == heightNew[length-1]){
            return heightNew[0]*length;
        }
        return helper(heights,0,heights.length);
    }

    private int helper(int[] heights,int start,int end){
        if(start == end){
            return 0;
        }
        if(start+1 == end){
            return heights[start];
        }
        int minIndex = start;
        for(int i = start +1;i<end;i++){
            if(heights[i] < heights[minIndex]){
                minIndex = i;
            }
        }
        int shortArea = (end - start) * heights[minIndex];
        int leftArea = helper(heights,start,minIndex);
        int rightArea = helper(heights,minIndex+1,end);
        int area = Math.max(shortArea,leftArea);
        return Math.max(area,rightArea);
    }
}
