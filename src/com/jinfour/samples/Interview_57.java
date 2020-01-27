package com.jinfour.samples;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Interview_57 extends Thread{

    //和为S的两个数字
    boolean findNumbersWithSum(int[] data, int s) {

        int l = 0, h = data.length - 1;

        while(l < h) {
            if (data[l] + data[h] == s) return true;

            if (data[l] + data[h] < s) {
                l++;
            }

            if (data[l] + data[h] > s) {
                h--;
            }
        }
        return false;

    }
}
