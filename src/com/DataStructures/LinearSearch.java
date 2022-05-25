package com.DataStructures;

public class LinearSearch {
    public int search(int[] array,int number){
        for(int i = 0;i < array.length;i++)
            if(array[i] == number)
                return i;
        return -1;
    }
}
