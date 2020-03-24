package com.jinfour.beautiful;

import java.util.TreeMap;

public class TreeMapSample {

    public static void main(String[] args){

        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("cba", 12);
        map.put("baa", 11);
        map.put("aba", 13);
        map.put("aca", 14);
        map.put("bca", 15);
        System.out.println(map);
    }
}
