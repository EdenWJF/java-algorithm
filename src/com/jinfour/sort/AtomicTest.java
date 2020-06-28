package com.jinfour.sort;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {

    private final AtomicInteger atoInt = new AtomicInteger(0);

    public AtomicTest() {
        atoInt.getAndIncrement();
    }

    public static void main(String[] args){
        AtomicTest t1 = new AtomicTest();
        AtomicTest t2 = new AtomicTest();
        AtomicTest t3 = new AtomicTest();
        System.out.println(t3.atoInt);
    }
}
