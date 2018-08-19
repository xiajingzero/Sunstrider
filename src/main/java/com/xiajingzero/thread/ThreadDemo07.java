package com.xiajingzero.thread;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by xiajing on 2018-8-19.
 */
public class ThreadDemo07 {
    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(2);
        final int count = 100000;
        Thread thread1 = new Thread(()->{
            long start = System.currentTimeMillis();
            List arrayList = new ArrayList();
            for (int i = 0; i < count; i++) {
                arrayList.add(i);
            }
            System.out.println("arrayList add: " + (System.currentTimeMillis() - start));
            for (int i = 0; i < count; i++) {
                arrayList.get(i);
            }
            System.out.println("arrayList get: " + (System.currentTimeMillis() - start));
            latch.countDown();
        });
        Thread thread2 = new Thread(()->{
            long start = System.currentTimeMillis();
            List linkedList = new LinkedList();
            for (int i = 0; i < count; i++) {
                linkedList.add(i);
            }
            System.out.println("linkedList add: " + (System.currentTimeMillis() - start));
            for (int i = 0; i < count; i++) {
                linkedList.get(i);
            }
            System.out.println("linkedList get: " + (System.currentTimeMillis() - start));
            latch.countDown();
        });
        thread1.start();
        thread2.start();
        latch.await();
    }
}
