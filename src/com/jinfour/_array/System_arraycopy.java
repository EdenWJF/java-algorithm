package com.jinfour._array;

import java.util.Arrays;

public class System_arraycopy {

    public static void main(String[] args) {
        String[] srcArr = {"1","2","3","4","5"};
        String[] destArr = {"6","7","8","9","10"};

        // srcPos + length <= srcArray.length
        // destPos + length <= destArray.length
        System.arraycopy(srcArr, 0, destArr, 3, 2);

        srcArr[0] = "aaa";


        System.out.println(Arrays.toString(destArr));
    }
}
