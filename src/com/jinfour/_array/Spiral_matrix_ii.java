package com.jinfour._array;

import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 *
 * https://leetcode.cn/problems/spiral-matrix-ii/description/
 *
 * algorithms
 * Medium (75.29%)
 * Likes:    824
 * Dislikes: 0
 * Total Accepted:    243.6K
 * Total Submissions: 323.8K
 * Testcase Example:  '3'
 *
 * 给你一个正整数 n ，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 *
 *
 * 示例 2：
 *
 *
 * 输入：n = 1
 * 输出：[[1]]
 *
 *
 *
 *
 * 提示：
 *
 *
 * 1
 *
 *
 */
public class Spiral_matrix_ii {

    public static void main(String[] args) {
        int[][] ints = new Spiral_matrix_ii().generateMatrix(3);
        for(int[] arr : ints) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int num = 1;
        while(true) {
            for(int i = left; i <= right; i++) {
                matrix[top][i] = num++;
            }
            if(++top > bottom) break;
            for(int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            if(--right < left) break;
            for(int i = right; i >= left; i--) {
                matrix[bottom][i] = num++;
            }
            if(--bottom < top) break;
            for(int i = bottom; i >= top; i--) {
                matrix[i][left] = num++;
            }
            if(++left > right) break;
        }
        return matrix;
    }
}