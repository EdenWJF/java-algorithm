package com.jinfour.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 无向简单图的节点
 * @author hoaven
 */
public class GraphNode<T> {
    T data;
    public List<GraphNode<T>> neighborList;
    boolean visited;

    public GraphNode(T data){
        this.data = data;
        neighborList = new ArrayList<GraphNode<T>>();
        visited = false;
    }

    public boolean equals(GraphNode<T> node){
        return this.data.equals(node.data);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<GraphNode<T>> getNeighborList() {
        return neighborList;
    }

    public void setNeighborList(List<GraphNode<T>> neighborList) {
        this.neighborList = neighborList;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    /**
     * 还原图中所有节点为未访问
     */
    public void restoreVisited(){
        restoreVisited(this);
    }

    /**
     * 还原node的图所有节点为未访问
     * @param node
     */
    private void restoreVisited(GraphNode<T> node){
        if(node.visited){
            node.visited = false;
        }

        List<GraphNode<T>> neighbors = node.neighborList;
        for(int i = 0; i < neighbors.size(); i++){
            restoreVisited(neighbors.get(i));
        }

    }
}
