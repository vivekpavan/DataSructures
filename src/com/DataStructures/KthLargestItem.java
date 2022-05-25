package com.DataStructures;

public class KthLargestItem {
    private Heap heap = new Heap();
    private int count;
    private int store;
    public int kthlargest(int[] numbers,int k){
        if(k < 1 || k > numbers.length)
            throw new IllegalStateException();
        for (int i = 0;i < numbers.length;i++){
            heap.insert(numbers[i]);
        }
        while(count != k){
            store = heap.remove();
            count++;
        }
        return store;
    }
}
