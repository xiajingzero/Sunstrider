package com.xiajingzero.enumDemo;

/**
 * Created by xiajing on 2018-8-16.
 */
public enum MathEnum {
    JIA,JIAN,CHENG,CHU;

    int compute(int i, int j){
        switch (this){
            case JIA:return i+j;
            case JIAN:return i-j;
            case CHENG:return i*j;
            case CHU:return i/j;
        }

        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        System.out.println(MathEnum.JIA.compute(1,2));
    }
}
