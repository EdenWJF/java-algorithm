package com.jinfour.graph;

import com.jinfour.graph.GraphNode;

import java.util.LinkedList;
import java.util.List;

public class GraphSearch<T> {

    public StringBuffer searchPathDFS = new StringBuffer();
    public StringBuffer searchPathBFS = new StringBuffer();

    //深度优先遍历
    public void searchDFS(GraphNode<T> root) {
        if (searchPathDFS.length() > 0) {
            searchPathDFS.append("->");
        }
        searchPathDFS.append(root.getData());
        root.setVisited(true);

        for (GraphNode node : root.getNeighborList()) {
            if (!node.isVisited()) {
                searchDFS(node);
            }
        }
    }

    //广度优先遍历
    public void searchBFS(GraphNode<T> root) {


        List<GraphNode> list = new LinkedList<>();
        if (searchPathBFS.length() > 0) {
            searchPathBFS.append("->");
        }
        searchPathBFS.append(root.getData());
        root.setVisited(true);

        list.add(root);

        while(list.size() > 0) {

            GraphNode node = list.remove(0);

            List<GraphNode> children = node.getNeighborList();
            for (GraphNode n : children) {
                if (!n.isVisited()) {
                    searchPathBFS.append("->");
                    searchPathBFS.append(n.getData());
                    n.setVisited(true);

                    list.add(n);
                }
            }

        }
    }
}
