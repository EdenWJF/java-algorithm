package com.jinfour.union_find;

public class UnionFind {

    private int[] parent;

    private double[] weight;

    public UnionFind(int n) {
        parent = new int[n];
        weight = new double[n];

        for(int i = 0; i < n; i++) {
            parent[i] = i;
            weight[i] = 1.0d;
        }
    }

    public void union(int x, int y, double value) {
        int rootX = find(x);
        int rootY = find(y);

        if(rootX == rootY) {
            return;
        }
        parent[rootX] = rootY;
        weight[rootX] = weight[y] * value / weight[x];
    }

    public int find(int x) {
        if(x != parent[x]) {
            int origin = parent[x];
            parent[x] = find(parent[x]);
            weight[x] = weight[x] * weight[origin];
        }
        return parent[x];
    }
}
