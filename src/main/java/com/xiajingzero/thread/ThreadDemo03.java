package com.xiajingzero.thread;

/**
 * Created by xiajing on 2018-8-15.
 */
public class ThreadDemo03 extends Thread {
    @Override
    public void run() {
        while (!interrupted()){
            System.out.println(233);
        }
        System.out.println("stop");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread demo = new ThreadDemo03();
        demo.start();
        Thread.sleep(20);
        demo.interrupt();
    }
}