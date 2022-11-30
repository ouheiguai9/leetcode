package com.byakuya.leetcode.merge;

import java.util.Arrays;

/** Created by ganzl at 2022/5/24 17:05 */
public class MergeArray {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(mergeSortedArray(new int[] {1, 2, 3}, new int[] {2, 5, 6})));
  }

  private static int[] mergeSortedArray(int[] a, int[] b) {
    int[] rtnVal = new int[a.length + b.length];
    int m = a.length - 1, n = b.length - 1, k = rtnVal.length - 1;
    if (a[0] >= b[n]) {
      System.arraycopy(b, 0, rtnVal, 0, b.length);
      System.arraycopy(a, 0, rtnVal, b.length, a.length);
    } else if (a[m] < b[0]) {
      System.arraycopy(a, 0, rtnVal, 0, a.length);
      System.arraycopy(b, 0, rtnVal, a.length, b.length);
    } else {
      while (m >= 0 && n >= 0) {
        if (a[m] > b[n]) {
          rtnVal[k--] = a[m--];
        } else {
          rtnVal[k--] = b[n--];
        }
      }
      if (m > 0) {
        System.arraycopy(a, 0, rtnVal, 0, m + 1);
      }
      if (n > 0) {
        System.arraycopy(b, 0, rtnVal, 0, n + 1);
      }
    }
    return rtnVal;
  }
}
