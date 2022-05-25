package com.DataStructures;

import java.util.Arrays;

public class Heapify {
    public void heapify(int[] numbers){
        int last_parent_index = numbers.length/2 - 1;
        for(int i = last_parent_index;i >= 0;i--)
            bubbleDown(numbers,i);
    }
    private void bubbleDown(int[] numbers,int index){
        int largerIndex = index;

        var leftChild_index = (index * 2) + 1;
        var rightChild_index = (index * 2) + 2;

        if(validate(numbers,leftChild_index,rightChild_index)  &&  numbers[leftChild_index] > numbers[rightChild_index]  && numbers[largerIndex] < numbers[leftChild_index])
            largerIndex = leftChild_index;


        if(validate(numbers,leftChild_index,rightChild_index)   &&  numbers[leftChild_index] < numbers[rightChild_index] && numbers[index] < numbers[rightChild_index])
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
    private boolean validate(int[] numbers,int leftChild_index,int rightChild_index){
        return rightChild_index < numbers.length && leftChild_index < numbers.length;
    }
    //the last element is the Right_index which is equal to numbers.length but
    //if we validate that , then array will go outOfBound
    //that is why the last element is not getting sorted.

    //IF WE DO A SEPERATE IMPLEMENTATION FOR THAT PARTICULAR CASE THEN WE CAN VALIDATE IT.
}
