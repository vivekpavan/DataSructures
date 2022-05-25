package com.DataStructures;

public class BubbleSort {
    public void sort(int[] array){
        boolean isSorted;
        for(int i = 0;i < array.length ; i++){
            isSorted = true;
            for(int j = 0;j < array.length - 1 - i;j++){
                if(array[j + 1] < array[j]) {
                    swap(array, j, j + 1);
                    isSorted = false;
                }
            }
            if(isSorted)
                return;
        }
    }
    private void swap(int[] array,int firstIndex,int secondIndex){
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }
}
