package com.jinfour.sort;

import java.util.PriorityQueue;

public class HeapSort {

    public static int[] maxHeapify(int[] array, int size) {
        // 从数组的尾部开始，直到第一个元素(角标为0)
        for (int i = size - 1; i >= 0; i--) {
            heapify(array, i, size);
        }
        return array;
    }

    private static void heapify(int[] arr, int currNode, int size) {
        if (currNode < size) {
            int left = currNode * 2 + 1;
            int right = currNode * 2 + 2;
            int max = currNode;

            if (left < size) {
                //根节点和左子节点比较
                if (arr[max] < arr[left]) {
                    max = left;
                }
            }

            if (right < size) {
                //把左子树和根节点中较大者和右子节点比较
                if (arr[max] < arr[right]) {
                    max = right;
                }
            }
            if (max != currNode) {
                swap(arr, currNode, max);
                heapify(arr, max, size);
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void heapSort(int[] array) {
        int size = array.length;
        for (int i = 0; i < array.length; i++) {
            maxHeapify(array, size);
            swap(array, 0, size - 1);
            size--;
        }
    }

    public static void main(String[] args){
        int[] arr = new int[]{4,3,5,7,1,9};
        heapSort(arr);
        for (int i = 0; i<arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

}

