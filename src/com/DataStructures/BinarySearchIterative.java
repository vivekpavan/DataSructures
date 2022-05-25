package com.DataStructures;

public class BinarySearchIterative {
    public int search(int[] array,int target,int left,int right){
//        left = 0;
//        right = array.length -1;
        int middle;
        while(left <= right){
            middle = (left + right)/2;
            if(array[middle] == target)
                return middle;
            if(array[middle] > target)
                right = middle - 1;
            else
                left = middle + 1;
        }
        return -1;
    }
}
