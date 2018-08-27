package com.xiajingzero.purview;

/**
 * Created by xiajing on 2018-8-27.
 */
public class PurviewDemo {
    public static final int ALLOW_SELECT = 1 << 0;//0001        1
    public static final int ALLOW_INSERT = 1 << 1;//0010        2
    public static final int ALLOW_UPDATE = 1 << 2;//0100        3
    public static final int ALLOW_DELETE = 1 << 3;//1000        4

    private int purview;

    public void setPurview(int pur){
        this.purview = pur;
    }

    //1|1=1, 1|0=1, 0|0=0
    public void enable(int pur){
        purview = purview | pur;
    }

    //1&1=1, 1&0=0, 0&0=0
    //~1=0, ~0=1
    public void disable(int pur){
        purview = purview & ~pur;
    }

    public boolean isAllowed(int pur){
        return (purview & pur) == pur;
    }

    public boolean isNotAllowed(int pur){
        return (purview & pur) == 0;
    }

    public int getPurview() {
        return purview;
    }

    public static void main(String[] args) {
        int pur = 0;
        PurviewDemo demo = new PurviewDemo();
        demo.setPurview(pur);
        demo.enable(ALLOW_INSERT);
        demo.enable(ALLOW_SELECT);
        System.out.println(Integer.toBinaryString(demo.getPurview()));


        System.out.println(demo.isAllowed(ALLOW_SELECT));
        System.out.println(demo.isAllowed(ALLOW_INSERT));
        System.out.println(demo.isAllowed(ALLOW_UPDATE));
        System.out.println(demo.isAllowed(ALLOW_DELETE));
    }
}
