package com.DataStructures;

public class Heap {
    private int[] array = new int[10];
    private int size;
    public void insert(int item){
        if(size == array.length)
            throw new IllegalStateException();

        array[size++] = item;
        int index = size - 1;
        //the below implementation ia also bubbleUp only;
        while(size > 0 && array[index] > array[parent(index)]){
            swap(index,parent(index));
            index = parent(index);
        }
    }
    private int parent(int index){
        return  (index - 1)/2;
    }
    public int remove(){
        if(size == 0)
            throw new IllegalStateException();
        if(size < 2){
            var removed_item = array[0];
            array[0] = 0;
            return removed_item ;
        }
        var removed_item = array[0];
        bubbleUp();
        bubbleDown(0);
        size--;
        return removed_item;
    }
    private void bubbleUp(){
        array[0] = array[size -1];
        array[size - 1] = 0;
    }
    private void bubbleDown(int parent){
        int left = (parent * 2) + 1;
        int right = (parent * 2) + 2;
        if(left > size - 1 || right > size - 1)
            return;
        if(array[left] >= array[right] && array[parent] < array[left]){
            swap(parent,left);
            bubbleDown(left);
        }
        else if(array[right] > array[left] && array[parent] < array[right]){
            swap(parent,right);
            bubbleDown(right);
        }

    }
    private void swap(int first,int second){
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}
