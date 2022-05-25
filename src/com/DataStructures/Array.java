package com.DataStructures;

public class Array {
    private int[] items;
    private int count;
    public Array (int length){
        items = new int[length];
    }

    public void print(){
        for (int i =0;i < count;i++)
            System.out.print(items[i]);
    }
    public void insert(int number){
        if(count == items.length){
            int[] array = new int[items.length * 2];
            for(int i =0 ; i < items.length ;i++)
                array[i] = items[i];
            items = array;
        }
        items[count++] = number;
    }
    public int indexOf(int number){
        for(int i =0;i <= count;i++){
            if(items[i] == number)
                return i;
        }
        return -1;
    }
    public void removeAt(int index){
        if(index < 0 || index >= items.length)
            throw new ArrayIndexOutOfBoundsException();
        if(index <= count) {
            items[index] = 0;
            for (int i = index; i < count; i++)
//                swap(items, i, i + 1);
                items[i] = items[i + 1];
            count--;
        }
    }
    private void swap(int[] array,int a,int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}

