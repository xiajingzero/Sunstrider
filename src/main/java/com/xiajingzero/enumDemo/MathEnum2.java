package com.xiajingzero.enumDemo;

/**
 * Created by xiajing on 2018-8-16.
 */
public enum MathEnum2 {
    JIA {
        @Override
        int compute(int i, int j) {
            return i+j;
        }
    },JIAN {
        @Override
        int compute(int i, int j) {
            return i-j;
        }
    },CHENG {
        @Override
        int compute(int i, int j) {
            return i*j;
        }
    },CHU {
        @Override
        int compute(int i, int j) {
            return i/j;
        }
    };

    abstract int compute(int i, int j);

    public static void main(String[] args) {
        System.out.println(MathEnum2.JIA.compute(1,2));
        System.out.println(System.nanoTime());
    }
}
