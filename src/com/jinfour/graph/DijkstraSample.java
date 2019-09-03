package com.jinfour.graph;

public class DijkstraSample {


    final static int[][] matrix = new int[][]{
            {0, 24, 8, 15, -1, -1, -1},  //a
            {-1, 0, -1, -1, 6, -1, -1},  //b
            {-1, -1, 0, -1, 7, 3, -1},   //c
            {-1, -1, -1, 0, -1, -1, 4},  //d
            {-1, -1, -1, -1, 0, -1, 9},  //e
            {-1, -1, -1, 5, 2, 0, 10},   //f
            {-1, 3, -1, -1, -1, -1, 0}   //g
    };

    public static void main(String[] args) {
        System.out.println(dijkstra(matrix));
    }

    static int dijkstra(int[][] matrix) {

        return -1;
    }

}
