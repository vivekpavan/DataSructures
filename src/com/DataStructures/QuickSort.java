package com.DataStructures;

import java.util.Arrays;

public class QuickSort {
    public void sort(int[] array){
        sort(array,0,array.length-1);
    }
    private void sort(int[] array,int start,int end){
        if(start >= end)
            return;
        int boundary = partition(array,start,end);
        sort(array,start,boundary -1);
        sort(array,boundary+1,end);
    }
    //so initially we are considering entire array is of right partition
    private int partition(int[] array,int start,int end){
        int pivot = array[end];
        int boundary = start - 1;
        for(int i = start;i <= end;i++)
            if(array[i] <= pivot)
                swap(array,i,++boundary);
        return boundary;
    }
    private void swap(int[] array,int firstIndex,int secondIndex){
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }
}

