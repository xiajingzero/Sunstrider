package com.xiajingzero.thread;

/**
 * Created by xiajing on 2018-8-15.
 */
public class NotifyDemoExpress {
    private int km;
    private String site;

    public NotifyDemoExpress(int km, String site) {
        this.km = km;
        this.site = site;
    }

    public synchronized void changeKm(int km){
        this.km = km;
        notifyAll();
    }

    private void changeSite(String site){
        this.site = site;
    }

    public synchronized void checkKm() throws InterruptedException {
        while(km <= 100){
            wait();
        }
        System.out.println("reachKm");
        this.site = "BJ";
        notifyAll();
    }

    public synchronized void checkSite() throws InterruptedException {
        while(site.equals("SH")){
            wait();
        }
        System.out.println("reachSite");
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
}
