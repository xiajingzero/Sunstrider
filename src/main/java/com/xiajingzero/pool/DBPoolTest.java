package com.xiajingzero.pool;

import java.sql.Connection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by xiajing on 2018-8-22.
 */
public class DBPoolTest {
    static DBPool pool = new DBPool(10);
    static CountDownLatch latch;

    public static void main(String[] args) throws InterruptedException {
        int threadCount = 50;
        latch = new CountDownLatch(threadCount);
        int count = 20;
        AtomicInteger got = new AtomicInteger();
        AtomicInteger notGot = new AtomicInteger();
        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(new Worker(count, got, notGot), "worker_"+i);
            thread.start();
        }
        latch.await();
        System.out.println("total: " + (threadCount * count));
        System.out.println("got: "+ got);
        System.out.println("notGot: "+ notGot);
    }

    static class Worker implements Runnable {
        int count;
        AtomicInteger got;
        AtomicInteger notGot;

        public Worker(int count, AtomicInteger got, AtomicInteger notGot) {
            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }

        @Override
        public void run() {
            while(count > 0){
                try{
                    Connection connection = pool.fetchConn(1000);
                    if(connection != null){
                        try{
                            connection.createStatement();
                            connection.commit();
                        }finally {
                            pool.releaseConn(connection);
                            got.incrementAndGet();
                        }
                    }else{
                        notGot.incrementAndGet();
                        System.out.println(Thread.currentThread().getName()+"等待超时！");
                    }
                }catch (Exception e){

                }finally {
                    count --;
                }
            }
            latch.countDown();
        }
    }
}
