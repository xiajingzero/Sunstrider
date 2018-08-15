package com.xiajingzero.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by xiajing on 2018-8-15.
 */
public class ThreadDemo02 implements Runnable {
    @Override
    public void run() {
        System.out.println("funnable");
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadDemo02 demo = new ThreadDemo02();
        Thread thread = new Thread(demo);
        thread.start();

        FutureTask<String> futureTask = new FutureTask(new callableDemo());
        Thread thread2 = new Thread(futureTask);
        thread2.start();
        String result = futureTask.get();
        System.out.println(result);
    }

    static class callableDemo implements Callable {

        @Override
        public String call() throws Exception {
            System.out.println("callable");
            return "hello callable";
        }
    }
}