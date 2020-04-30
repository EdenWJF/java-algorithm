package com.jinfour._array;

public class PrintMatrixInCircle {

    /**
     * 顺时针打印矩阵
     */

    static void printMatrixInCircle(int[][] matrix) {
        int circle = 0, rows = matrix.length, columns = matrix[0].length;

        while(circle * 2 < rows && circle * 2 < columns) {
            printCircle(matrix, rows, columns, circle);
            circle++;
        }
    }

    private static void printCircle(int[][] matrix, int rows, int columns, int circle) {
        int endX = columns - circle - 1;//右上角
        int endY = rows - circle - 1;//右下角
        //上行
        for (int i = circle; i <= endX; i++) {
            System.out.print(matrix[circle][i] + ",");
        }

        if (circle < endY) {
            //右列
            for (int i = circle + 1; i <= endY; i++) {
                System.out.print(matrix[i][endX] + ",");
            }
        }

        if (circle < endX && circle < endY) {
            //下行
            for (int i = endX - 1; i >= circle; i--) {
                System.out.print(matrix[endY][i] + ",");
            }
        }

        if (circle < endX && circle < endY - 1) {
            //左列
            for (int i = endY - 1; i > circle; i--) {
                System.out.print(matrix[i][circle] + ",");
            }
        }

    }

    public static void main(String[] args){
        int[][] nums = {
                {0, 1, 2, 3, 4},
                {5, 6, 7, 8, 9},
//                {10, 11, 12, 13, 14},
//                {15, 16, 17, 18, 19},
//                {20, 21, 22, 23, 24}
        };

        printMatrixInCircle(nums);
    }
}
