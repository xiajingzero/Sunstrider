package com.xiajingzero.thread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by xiajing on 2018-8-17.
 */
public class CountDownLatchDemo {
    private static CountDownLatch latch = new CountDownLatch(5);

    static class JobThread extends Thread{
        @Override
        public void run(){
            System.out.println(currentThread().getName());
            latch.countDown();
        }
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 5; i++) {
            new Thread(new JobThread()).start();
        }
        latch.await();
        System.out.println("main");
    }
}
