package com.jinfour.dfs;

public class SearchWord {

    static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

    public static void main(String[] args) {

    }

    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean dfs = dfs(board, i, j, new boolean[board.length][board[0].length], word, 0);
                if (dfs) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean dfs(char[][] board, int row, int col, boolean[][] visited, String word, int index) {
        if(visited[row][col] || board[row][col] != word.charAt(index)) {
            return false;
        }
        if (index == word.length()-1) {
            return true;
        }
        visited[row][col] = true;
        for (int[] d : dir) {
            int newRow = row+d[0], newCol = col+d[1];
            if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length) {
                boolean dfs = dfs(board, newRow, newCol, visited, word, index + 1);
                if (dfs) {
                    return true;
                }
            }
        }
        visited[row][col] = false;
        return false;
    }
}
