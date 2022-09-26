package com.jinfour.dfs;

/*
 * @lc app=leetcode.cn id=329 lang=java
 *
 * [329] 矩阵中的最长递增路径
 *
 * https://leetcode.cn/problems/longest-increasing-path-in-a-matrix/description/
 *
 * algorithms
 * Hard (51.22%)
 * Likes:    706
 * Dislikes: 0
 * Total Accepted:    85.7K
 * Total Submissions: 167.3K
 * Testcase Example:  '[[9,9,4],[6,6,8],[2,1,1]]'
 *
 * 给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。
 *
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[9,9,4],[6,6,8],[2,1,1]]
 * 输出：4
 * 解释：最长递增路径为 [1, 2, 6, 9]。
 *
 * 示例 2：
 *
 *
 * 输入：matrix = [[3,4,5],[3,2,6],[2,2,1]]
 * 输出：4
 * 解释：最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
 *
 *
 * 示例 3：
 *
 *
 * 输入：matrix = [[1]]
 * 输出：1
 *
 *
 *
 *
 * 提示：
 *
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1
 * 0
 *
 *
 */
public class Longest_increasing_path_in_a_matrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{9,9,4},{6,6,8},{2,1,1}};
        System.out.println(new Longest_increasing_path_in_a_matrix().longestIncreasingPath(matrix));
    }

    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] memo = new int[row][col];
        int max = 0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                max = Math.max(max, dfs(matrix, i, j, memo));
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] memo) {
        int curr = matrix[i][j];
        if(memo[i][j] > 0) return memo[i][j];
        int next = 0;
        if(i+1 < matrix.length && curr < matrix[i+1][j]) {
            memo[i+1][j] = dfs(matrix, i+1, j, memo);
            next = Math.max(next, memo[i+1][j]);
        }
        if(i-1 > 0 && curr < matrix[i-1][j]) {
            memo[i-1][j] = dfs(matrix, i-1, j, memo);
            next = Math.max(next, memo[i-1][j]);
        }
        if(j+1 < matrix[0].length && curr < matrix[i][j+1]) {
            memo[i][j+1] = dfs(matrix, i, j+1, memo);
            next = Math.max(next, memo[i][j+1]);
        }
        if(j-1 > 0 && curr < matrix[i][j-1]) {
            memo[i][j-1] = dfs(matrix, i, j-1, memo);
            next = Math.max(next, memo[i][j-1]);
        }
        memo[i][j] = 1 + next;
        return memo[i][j];
    }
}




