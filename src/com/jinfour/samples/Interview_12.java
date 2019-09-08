package com.jinfour.samples;

public class Interview_12 {

    //矩阵中的路径

    static boolean hasPath(char[][] matrix, String target) {
        char[] str = target.toCharArray();

        int cols = matrix[0].length;
        int rows = matrix.length;
        boolean[] visited = new boolean[cols*rows];

        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int pathLength = 0;

                if (findPath(matrix, i, j, pathLength, str, visited)) {
                    return true;
                }

            }
        }
        return false;
    }

    static boolean findPath(char[][] matrix, int row, int col, int pathLength, char[] str, boolean[] visited) {

        //当把字符串遍历结束，代表已完成查找
        if (pathLength > str.length - 1) {
            return true;
        }

        boolean hasPath = false;

        //如果值相同且没被访问过，遍历下个节点
        if ( row >= 0 && row < matrix.length
                && col >= 0 && col < matrix[0].length
                && matrix[row][col] == str[pathLength]
                && !visited[row * matrix[0].length + col] ) {

            pathLength++;
            visited[row * matrix[0].length + col] = true;

            hasPath = findPath(matrix, row, col + 1, pathLength, str, visited)
                        || findPath(matrix, row, col - 1, pathLength, str, visited)
                        || findPath(matrix, row + 1, col, pathLength, str, visited)
                        || findPath(matrix, row - 1, col, pathLength, str, visited);

            if (!hasPath) {
                pathLength--;
                visited[row * matrix[0].length + col] = false;
                return false;
            }

        }

        return hasPath;
    }

    public static void main(String[] args){
        char[][] matrix = new char[][] {
                {'a','b','t','g'},
                {'c','f','c','s'},
                {'j','d','e','h'}
        };

        if (hasPath(matrix, "bfcea")) {
            System.out.println("turrrrrr");
        }else {
            System.out.println("falsssssss");
        }

    }
}
