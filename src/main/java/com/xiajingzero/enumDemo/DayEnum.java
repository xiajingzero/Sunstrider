package com.xiajingzero.enumDemo;

/**
 * Created by xiajing on 2018-8-16.
 *
 */
public enum DayEnum {
    ONE(DayType.SHAO),TWO(DayType.SHAO),Three(DayType.SHAO),FOUR(DayType.SHAO),FIVE(DayType.SHAO),
    SIX(DayType.DUO),SEVEN(DayType.DUO);

    private DayType dayType;
    DayEnum(DayType dayType){
        this.dayType = dayType;
    }
    int computeSalary(int days){
        return this.dayType.computeSalary(days);
    }

    private enum DayType{
        DUO {
            @Override
            int computeSalary(int days) {
                return days*3;
            }
        },SHAO {
            @Override
            int computeSalary(int days) {
                return days*2;
            }
        };

        abstract int computeSalary(int days);
    }

    public static void main(String[] args) {
        System.out.println(DayEnum.ONE.computeSalary(8));
        System.out.println(DayEnum.SEVEN.computeSalary(8));
    }
}
