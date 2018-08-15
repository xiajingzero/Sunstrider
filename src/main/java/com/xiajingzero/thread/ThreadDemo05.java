package com.xiajingzero.thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by xiajing on 2018-8-15.
 */
public class ThreadDemo05 implements Runnable {
    @Override
    public void run() {
        int i = 90;
        while(i >= 0){
            System.out.println("name: " + Thread.currentThread().getName()+", i=" +i);
            i = i-10;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadDemo05 demo = new ThreadDemo05();
        Thread thread = new Thread(demo);
        thread.run();

        TimeUnit.SECONDS.sleep(3);

        ThreadDemo05 demo2 = new ThreadDemo05();
        Thread thread2 = new Thread(demo2);
        thread2.start();
    }
}
