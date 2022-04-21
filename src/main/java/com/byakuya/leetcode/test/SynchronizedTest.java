package com.byakuya.leetcode.test;

/**
 * @author 田伯光
 * @createTime 2022/4/21 13:40
 * @description SynchronizedTest
 */
public class SynchronizedTest {
    public static void main(String[] args) {
        SynchronizedInner common = new SynchronizedInner(0);
        for(int i = 0;i<5;i++) {
            new Thread(common::sync).start();
        }

        for(int i = 0;i<5;i++) {
            int iter = i;
            new Thread(()->{
                new SynchronizedInner(iter).sync();
            }).start();
        }
    }

    static class SynchronizedInner {
        private final int i;
        SynchronizedInner(int i) {
            this.i = i;
        }

        public synchronized void sync() {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+":\t"+i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
