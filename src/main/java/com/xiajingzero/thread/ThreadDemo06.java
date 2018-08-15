package com.xiajingzero.thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by xiajing on 2018-8-15.
 */
public class ThreadDemo06 implements Runnable {
    public synchronized void m1() throws InterruptedException {
        String name = Thread.currentThread().getName();
        System.out.println(name + ", begin");
        TimeUnit.SECONDS.sleep(1);
        System.out.println(name + ", end");
        TimeUnit.SECONDS.sleep(2);
    }

    @Override
    public void run() {
        try {
            m1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ThreadDemo06 demo = new ThreadDemo06();
        Thread thread1 = new Thread(demo);
        Thread thread2 = new Thread(demo);

        thread1.start();
        thread2.start();
    }
}
