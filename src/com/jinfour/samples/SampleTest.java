package com.jinfour.samples;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SampleTest {


    public static int i = 1;

    static {
        i = 2;
        System.out.println(i);
    }

    @Test
    public void ts1() {
        Interview_02 i1 = Interview_02.getInstance();

        Interview_02 i2 = Interview_02.getInstance();
        Interview_02 i3 = Interview_02.getInstance();

        if (i1 == i2 && i2 == i3) {
            System.out.println("同一对象");
        }

        String a = "aaaa";
        edit(a);
        System.out.println(a);

    }

    void edit(String a) {
        a = "bbb";
    }
}
