package com.jinfour._tree;

public class RebuildTreeByPostArr {

    //根据后序遍历，重建BST
    private static class Node {
        int val;

        Node left;
        Node right;

        Node(int value) {
            this.val = value;
        }
    }

    public static Node rebuild(int[] arr) {
        return findHead(arr, 0, arr.length - 1);
    }

    private static Node findHead(int[] arr,int startIndex, int headIndex) {
        if (startIndex == headIndex) {
            return new Node(arr[headIndex]);
        }

        Node head = new Node(arr[headIndex]);

        int leftChildHeadIndex = -1, leftStartIndex = -1;
        int rightChildHeadIndex = -1, rightStartIndex = -1;
        for (int i = 0; i < headIndex; i++) {
            if (arr[i] < arr[headIndex]) {
                leftChildHeadIndex = i;
            }
            if (arr[i] > arr[headIndex]) {
                rightChildHeadIndex = i;
            }
        }
        for (int i = 0; i < headIndex; i++) {
            if (arr[i] < arr[headIndex]) {
                leftStartIndex = i;
                break;
            }
        }
        for (int i = 0; i < headIndex; i++) {
            if (arr[i] > arr[headIndex]) {
                rightStartIndex = i;
                break;
            }
        }

        if (leftChildHeadIndex >= 0) {
            head.left = findHead(arr, leftStartIndex, leftChildHeadIndex);
        }
        if (rightChildHeadIndex >= 0) {
            head.right = findHead(arr, rightStartIndex, rightChildHeadIndex);
        }
        return head;
    }

    public static void main(String[] args){
        int[] arr = new int[]{1,4,3,7,9,8,5};
        Node rebuild = rebuild(arr);
        System.out.println("over");
    }
}
