package com.xiajingzero.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by xiajing on 2018-8-17.
 */
public class CyclicBarrierDemo {
    private static CyclicBarrier barrier = new CyclicBarrier(5);

    static class JobThread extends Thread{
        @Override
        public void run(){
            System.out.println(currentThread().getName()+" start");
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(currentThread().getName()+" end");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new JobThread()).start();
        }
        System.out.println("main");
    }
}
