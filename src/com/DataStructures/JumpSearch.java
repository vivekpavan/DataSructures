package com.DataStructures;

public class JumpSearch {
    public int search(int[] array,int target){
        int block_size = (int) Math.sqrt(array.length);
        int start = 0;
        int next = block_size;
        while(start < array.length){
            if(array[next - 1] == target)
                return next-1;
            if(array[next - 1] > target)
                for(int i = next - 2;i >= start;i--)
                    if(array[i] == target)
                        return i;
            if(array[next-1] < target){
                start = next;
                next = next + block_size;
            }
            if(next > array.length -1)
                next = array.length;
        }
        return -1;
    }
    public int searched(int[] array,int target){
        int block_size = (int)Math.sqrt(array.length);
        int start = 0;
        int next = block_size;
        while(start  < array.length && array[next - 1] < target){
            start = next;
            next += block_size;
            if(next > array.length)
                next = array.length;
        }
        //Now we get one block
        for(int i = start;i < next ; i++)
            if(array[i] == target)
                return i;
        return -1;
    }
}
