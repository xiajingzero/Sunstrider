package com.xiajingzero.thread;

/**
 * Created by xiajing on 2018-8-15.
 */
public class ThreadDemo04 implements Runnable {
    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            System.out.println("running");
        }
        System.out.println("stop");
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadDemo04 demo = new ThreadDemo04();
        Thread thread = new Thread(demo);
        thread.start();
        thread.sleep(20);
        thread.interrupt();
    }
}
