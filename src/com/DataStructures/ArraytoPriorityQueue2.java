package com.DataStructures;

import java.util.Arrays;

public class ArraytoPriorityQueue2 {
    private int[] items = new int[5];
    private int count;

    public void add(int item){
        if(isFull())
            throw new IllegalStateException();

        int i = shiftItemsToInsert(item);

        items[i] = item;
        count++;
    }

    public int shiftItemsToInsert(int item){
        int i;
        for(i = count - 1;i >= 0 ;i --){
            if(items[i] > item)
                items[i + 1] = items[i];
            else break;
        }
        return i + 1;
    }

    public int remove(){
        return items[--count];
    }

    @Override
    public String toString(){
        return Arrays.toString(items);
    }

    public boolean isFull(){
        return count==items.length;
    }

    public boolean isEmpty(){
        return count == 0;
    }
}
