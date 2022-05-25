package com.DataStructures;

import java.util.Arrays;

public class HeapSort {
    private final int[] numbers = {5,3,10,1,4,2};
    private final Heap heap = new Heap();
    public void heapSort(){
        for(var number : numbers)
            heap.insert(number);
        for(var i = 0;i < numbers.length;i++)
            numbers[i] = heap.remove();
        System.out.println(Arrays.toString(numbers));
    }
}
