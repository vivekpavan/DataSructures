package com.DataStructures;

import java.util.Collections;

public class BinarySearchRecursive {
    public int search(int[] array,int target){
        int index = search(array,target,0,array.length-1);
        return index;
    }
    private int search(int[] array,int target,int left,int right){
        if(right < left)
            return -1;

        int middle = (left + right)/2;
        if (array[middle] == target)
                return middle;
        if(array[middle] > target)
            return search(array,target,left,middle-1);
        return search(array,target,middle+1,right);
    }
}
