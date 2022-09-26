package com.jinfour.dynamic;

import java.util.HashSet;
import java.util.Set;

public class Ugly_number_ii {

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }

    public static int nthUglyNumber(int n) {
        if(n < 6) {
            return n;
        }
        Set<Integer> ugly = new HashSet<>();
        ugly.add(2);
        ugly.add(3);
        ugly.add(4);
        ugly.add(5);
        int target = 0;
        for(int c = 6, j=6; j <= n;c++) {
            if ((c%2 == 0 && ugly.contains(c/2)) || (c%3 == 0 && ugly.contains(c/3)) || (c%5 == 0 && ugly.contains(c/5))) {
                ugly.add(c);
                target = c;
                j++;
            }
        }
        return target;
    }
}
