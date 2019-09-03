package com.jinfour.samples;

public class Interview_05 {

    //字符串，
    //== 对象间使用==:比较的是变量(栈)内存中存放的对象的(堆)内存地址，是否是同一个对象
    //== 基础类型使用==：比较的是栈内值内容是否相等
    //equals比较的是对象内容是否相等，equals是Object类的方法，默认实现是使用==比较。


    public static void main(String[] args){

        String s1 = "aa aaa aa";
        String s2 = "aaaa" +new String("aaa");
//        String s2 = s1;
        System.out.println("s1 == s2:" + (s1 == s2));
        System.out.println("s1.equals(s2):" + s1.equals(s2));

        String s3 = new String("aaaaaaa");
        String s4 = new String("aaaaaaa");
        System.out.println("s3 == s4:" + (s3 == s4));
        System.out.println("s3.equals(s4):" + s3.equals(s4));

        String s0 = s1.replaceAll(" ", "%20");
        System.out.println(s0);
    }


    //替换空格

    void replaceBlank(char[] arr) {

        int len = arr.length;




    }
}
