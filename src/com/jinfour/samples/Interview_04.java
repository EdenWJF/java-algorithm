package com.jinfour.samples;

public class Interview_04 {

    final static int[][] matrix = new int[][]{
            {1, 2, 8, 9},       //a
            {2, 4, 9, 12},      //b
            {4, 7, 10, 13},     //c
            {6, 8, 11, 15},     //d
    };

    //在递增二维数组中找指定的整数
    public static void main(String[] args){
        System.out.println(findTarget(matrix, 5));
    }

    static boolean findTarget(int[][] arr, int target) {

        //首先取二维数组最右上角的坐标
        int m = 0, n = arr[0].length - 1;

        while(m <= arr.length - 1 && n >= 0) {

            if (arr[m][n] == target) {
                return true;
            }

            if (arr[m][n] > target) {
                n--;
                continue;
            }

            if (arr[m][n] < target) {
                m++;
                continue;
            }

        }




        return false;
    }
}
