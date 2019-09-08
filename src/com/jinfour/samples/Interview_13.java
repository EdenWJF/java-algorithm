package com.jinfour.samples;

public class Interview_13 {

    //机器人的运动范围

    static int movingCount(char[][] matrix, int k) {

        int cols = matrix[0].length;
        int rows = matrix.length;

        int col = 0, row = 0;
        boolean[] visited = new boolean[cols*rows];

        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        return movingCountCore(matrix, row, col, visited, k);


    }

    static int movingCountCore(char[][] matrix, int row, int col, boolean[] visited, int k) {

        int count = 0;
        if(check(matrix, row, col, k, visited)) {
            visited[row * matrix[0].length + col] = true;
            count = 1 + movingCountCore(matrix, row + 1, col, visited, k) +
            movingCountCore(matrix, row,  col + 1, visited, k) +
            movingCountCore(matrix, row - 1, col, visited, k) +
            movingCountCore(matrix, row, col - 1, visited, k);
        }

        return count;


    }

    //判断是否符合要求
    static boolean check(char[][] matrix, int row, int col, int k, boolean[] visited) {

        if ( row >= 0 && row < matrix.length
                && col >= 0 && col < matrix[0].length
                && getDigitSum(row) + getDigitSum(col) <= k
                && !visited[row * matrix[0].length + col] ) {

            return true;

        }

        return false;

    }

    //计算坐标的数位之和
    static int getDigitSum(int num) {
        int sum = 0;
        while(num > 0) {
            sum += num%10;
            num = num/10;
        }
        return sum;
    }

    public static void main(String[] args){
        char[][] matrix = new char[][] {
                {'a','b','t','g'},
                {'c','f','c','s'},
                {'j','d','e','h'}
        };

        System.out.println(movingCount(matrix, 2));

    }
}
