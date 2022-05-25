package com.DataStructures;

public class Heapify2 {
    public void heapify(int[] numbers){
        int last_parent_index = numbers.length/2 - 1;
        for(int i = last_parent_index;i >= 0;i--)
            bubbleDown(numbers,i);
    }
    private void bubbleDown(int[] numbers,int index){
        int largerIndex = index;

        var leftChild_index = (index * 2) + 1;
        if(leftChild_index < numbers.length  && numbers[largerIndex] < numbers[leftChild_index])
            largerIndex = leftChild_index;


        var rightChild_index = (index * 2) + 2;
        if(rightChild_index < numbers.length && numbers[index] < numbers[rightChild_index])
            largerIndex = rightChild_index;

        if(index == largerIndex)
            return;

        swap(numbers,index,largerIndex);
        bubbleDown(numbers,largerIndex);
    }
    private void swap(int[] numbers,int first_index,int second_index){
        var temp = numbers[first_index];
        numbers[first_index] = numbers[second_index];
        numbers[second_index] = temp;
    }
}
