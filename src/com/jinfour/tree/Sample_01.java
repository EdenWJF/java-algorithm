package com.jinfour.tree;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Sample_01 {

    public static void main(String[] args){

        Node n0 = new Node();n0.setId(0);n0.setInfo("n0");
        Node n1 = new Node();n1.setId(1);n1.setInfo("n1");n1.setParent(n0);
        Node n2 = new Node();n2.setId(2);n2.setInfo("n2");n2.setParent(n0);
        Node n3 = new Node();n3.setId(3);n3.setInfo("n3");n3.setParent(n2);
        Node n4 = new Node();n4.setId(4);n4.setInfo("n4");n4.setParent(n2);
        Node n5 = new Node();n5.setId(5);n5.setInfo("n5");n5.setParent(n0);
        Node n8 = new Node();n8.setId(8);n8.setInfo("n8");n8.setParent(n5);
        Node n7 = new Node();n7.setId(7);n7.setInfo("n7");n7.setParent(n5);
        Node n6 = new Node();n6.setId(6);n6.setInfo("n6");n6.setParent(n5);


        //List<Node> list = Arrays.asList(n0,n1,n2,n3,n4,n5,n6,n7,n8);

        List<Node> list = new ArrayList<>();
        list.add(n0);
        list.add(n1);
        list.add(n2);
        list.add(n3);
        list.add(n4);
        list.add(n5);
        list.add(n8);
        list.add(n7);
        list.add(n6);

        Map<Integer, Node> resourceMap = list.stream().collect(Collectors.toMap(Node::getId,
                Function.identity()));

        Iterator<Node> iterator = list.iterator();

        while (iterator.hasNext()) {
            Node r = iterator.next();
            if (null != r.getParent() && 0 != r.getId()) {
                resourceMap.get(r.getParent().getId()).getChildren().add(r);
                iterator.remove();
            }
        }

        System.out.println(resourceMap.get(0).toString());
    }

    static class Node {
        private Integer id;

        private String info;

        private Node parent;

        private List<Node> children = new ArrayList<>();

        public List<Node> getChildren() {
            return children;
        }

        public void setChildren(List<Node> children) {
            this.children = children;
        }


        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }
    }

    static class NodeMap {
        private Integer id;

        private String info;

        private List<Node> children;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public List<Node> getChildren() {
            return children;
        }

        public void setChildren(List<Node> children) {
            this.children = children;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }
    }


}
