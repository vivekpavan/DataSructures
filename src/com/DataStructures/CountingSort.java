package com.DataStructures;

import java.util.Arrays;

public class CountingSort {
    public int[] sort(int[] array){
        if(array.length == 0)
            return array;
        int max = findMax(array);
        int[] countArray = new int[max + 1];
        for(int i =0;i < array.length;i++)
            countArray[array[i]]++;
        int j = 0;
        for(int i = 0;i < countArray.length;i++){
            while(countArray[i] >= 1){
                array[j++] = i;
                countArray[i]--;
            }
        }
        return array;
    }
    private int findMax(int[] array){
        int max = Integer.MIN_VALUE;
        for(int i = 0;i < array.length;i++)
            if(array[i] > max)
                max = array[i];
        return max;
    }
}
