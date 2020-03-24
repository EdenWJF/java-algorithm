package com.jinfour.beautiful;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Stack;

public class Queen8 {

    /**
     *
     * 八皇后
     *
     */

    static int MAX = 8;
    int[] ans = new int[MAX];
    static int count = 0;

    public static void main(String[] args){
        long ti = System.currentTimeMillis();
        Queen8 queen8 = new Queen8();
        queen8.put(0);
        System.out.printf("共有%d种解法", count);
        long tl = System.currentTimeMillis();
        System.out.println(tl - ti);

    }

    private void put(int n) {
        if (n == MAX) {
            print();
            return;
        }

        //此处循环代表，在某一行中，从第一列到最后一列循环尝试
        for (int i = 0; i < MAX; i++) {
            ans[n] = i;

            if (judge(ans, n)) {
                //不冲突
                put(n+1);
            }
        }
    }

    private boolean judge(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == arr[n] || Math.abs(arr[i] - arr[n]) == Math.abs(n - i)) {
                return false;
            }
        }
        return true;
    }

    private void print() {
        count++;
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println("");
    }

}
