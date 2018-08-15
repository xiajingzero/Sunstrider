package com.xiajingzero.thread;

/**
 * Created by xiajing on 2018-8-15.
 */
public class NotifyDemoMain {
    static NotifyDemoExpress express = new NotifyDemoExpress(1, "SH");

    static class checkKm extends Thread {
        @Override
        public void run(){
            try {
                express.checkKm();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class checkSite extends Thread {
        @Override
        public void run(){
            try {
                express.checkSite();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            new checkKm().start();
        }
        for (int i = 0; i < 3; i++) {
            new checkSite().start();
        }
        Thread.sleep(1000);
        express.changeKm(101);

    }
}
