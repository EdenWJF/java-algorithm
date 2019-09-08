package com.jinfour.prob;

public class KmpSample {


    static int[] getNext(char[] p) {
        int[] next = new int[p.length + 1];
        next[0] = -1;
        int i = 0, j = -1;

        while (i < p.length) {
            if (j == -1 || p[i] == p[j]) {
                ++i;
                ++j;
                next[i] = j;
            } else
                j = next[j]; //精妙
        }

        return next;
    }

    static int KMP(char[] t, char[] p) {
        int i = 0;
        int j = 0;

        int[] next = getNext(p);

        while (i < t.length && j < p.length) {
            if (j == -1 || t[i] == p[j]) {
                i++;
                j++;
            } else
                j = next[j];
        }

        if (j == p.length)
            return i - j;
        else
            return -1;
    }
}
