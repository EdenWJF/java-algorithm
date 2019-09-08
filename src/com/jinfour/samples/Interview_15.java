package com.jinfour.samples;

public class Interview_15 {

    //二进制中1的个数
    static int numberOf1(int num) {
        int count = 0;
        while(num > 0) {
            if((num & 1) == 1) count++;
            num = num >> 1;
        }
        return count;
    }

    //二进制中1的个数
    static int numberOf1_2(int num) {
        int count = 0;
        while(num > 0) {
            count++;
            num = (num - 1) & num;
        }
        return count;
    }

    public static void main(String[] args){
        System.out.println(numberOf1_2(15));
    }
}
