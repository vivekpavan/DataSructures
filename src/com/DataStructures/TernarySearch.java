package com.DataStructures;

public class TernarySearch {
    public int search(int[] array,int target){
        int index = search(array,target,0,array.length-1);
        return index;
    }
    private int search(int[] array,int target,int left,int right){
        if(right < left)
            return -1;
        int partition_size = (right - left)/3;
        int mid1 = left + partition_size;
        int mid2 = right - partition_size;
        if(array[mid1] == target)
            return mid1;
        if(array[mid2] == target)
            return mid2;
        //if target is in middle partition
        if(array[mid1] < target && array[mid2] > target)
            return search(array,target,mid1+1,mid2-1);
        //if target is in left partition
        if(array[mid1] > target)
            return search(array,target,left,mid1-1);
        //if target is in right partition
        return search(array,target,mid2+1,right); // array[mid2] < target
    }
}
