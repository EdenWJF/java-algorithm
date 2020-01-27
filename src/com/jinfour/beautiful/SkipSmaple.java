package com.jinfour.beautiful;

import org.junit.Before;
import org.junit.Test;

import java.lang.invoke.MethodHandle;
import java.util.Random;
import java.util.concurrent.ConcurrentSkipListMap;

public class SkipSmaple {

    //跳跃表，concurrentSkipList

    ConcurrentSkipListMap<Long, String> skipListMap = new ConcurrentSkipListMap();

    @Before
    public void init() {
        Random random = new Random();

        for(int i = 0; i < 10000000; i++) {
            skipListMap.put(random.nextLong(), "222");
        }


    }

    @Test
    public void test1() {
        for (Long key : skipListMap.keySet()) {
            System.out.println(key);
        }
    }



}
