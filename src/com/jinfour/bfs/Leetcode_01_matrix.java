package com.jinfour.bfs;

import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=542 lang=java
 *
 * [542] 01 矩阵
 *
 * https://leetcode.cn/problems/01-matrix/description/
 *
 * algorithms
 * Medium (46.35%)
 * Likes:    758
 * Dislikes: 0
 * Total Accepted:    115.8K
 * Total Submissions: 249.9K
 * Testcase Example:  '[[0,0,0],[0,1,0],[0,0,0]]'
 *
 * 给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
 *
 * 两个相邻元素间的距离为 1 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 *
 * 输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：[[0,0,0],[0,1,0],[0,0,0]]
 *
 *
 * 示例 2：
 *
 *
 *
 *
 * 输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
 * 输出：[[0,0,0],[0,1,0],[1,2,1]]
 *
 *
 *
 *
 * 提示：
 *
 *
 * m == mat.length
 * n == mat[i].length
 * 1
 * 1
 * mat[i][j] is either 0 or 1.
 * mat 中至少有一个 0 
 *
 *
 */
public class Leetcode_01_matrix {
    static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

    public static void main(String[] args) {
        int[][] matrix = {{0,0,0},{0,1,0},{1,1,1}};
        updateMatrix(matrix);
        for (int[] m : matrix) {
            for(int i : m) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    public static int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue = new LinkedList<>();
        int row = mat.length;
        int col = mat[0].length;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(mat[i][j] == 0) {
                    queue.offer(new int[]{i,j});
                }else {
                    mat[i][j] = -1;
                }
            }
        }
        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            int x = node[0], y = node[1];
            for(int[] d : dir) {
                int next_x = x + d[0];
                int next_y = y + d[1];
                if(next_x >= 0 && next_x < row
                        && next_y >= 0 && next_y < col
                        && mat[next_x][next_y] == -1) {
                    mat[next_x][next_y] = mat[x][y] + 1;
                    queue.offer(new int[]{next_x, next_y});
                }
            }
        }
        return mat;
    }
}



