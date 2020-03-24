package com.jinfour.sort;

import java.util.PriorityQueue;

public class HeapSort {


    public int[] heapSort(int[] array) {
        buildMaxHeap(array, array.length);

        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);
            buildMaxHeap(array, i - 1);
        }
        return array;
    }

    private int[] buildMaxHeap(int[] array, int len) {
        for (int i = (len/2 - 1); i >= 0; i--) {
            adjustHeap(array, len, i);
        }
        return array;
    }

    private void adjustHeap(int[] array, int length, int head) {
        int left = head * 2 + 1;
        int right = head * 2 + 2;
        int maxIndex = head;
        if ( left < length && array[head] < array[maxIndex]) {
            maxIndex = left;
        }
        if (right < length && array[head] < array[maxIndex]) {
            maxIndex = right;
        }
        if (maxIndex != head) {
            //交换位置

            adjustHeap(array, length, maxIndex);
        }
    }



    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args){
        PriorityQueue queue = new PriorityQueue();
    }

}

