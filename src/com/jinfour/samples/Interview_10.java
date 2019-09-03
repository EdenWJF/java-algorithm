package com.jinfour.samples;

public class Interview_10 {

    //斐波那契数列
    static long fibonacci(int n) {
        int[] result = new int[] {0, 1};

        if (n < 2) {
            return result[n];
        }

        long a = 1;
        long b = 0;
        long c = 0;

        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        return c;
    }

    public static void main(String[] args){
        System.out.println(fibonacci(60));
    }
}
