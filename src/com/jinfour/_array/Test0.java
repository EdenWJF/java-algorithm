package com.jinfour._array;

public class Test0 extends Tes{
    static int a =350;
    public static void main(String[] args){
        Test0 t1 = new Test0();
        t1.a++;
        Test0 t2 = new Test0();
        t2.a++;
        t1 = new Test0();
        t1.a++;
        Test0.a--;
        System.out.println(a);
    }
}
