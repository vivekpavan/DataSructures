package com.DataStructures;

import java.util.Arrays;

public class ArraytoStack {
    int[] array;
    private int count;
    public ArraytoStack(int size){
        array = new int[size];
    }
    public void push(int number){
        if(count == array.length)
            throw new StackOverflowError();
        array[count++] = number;
    }
    public int pop(){
        if(isEmpty())
            throw new IllegalStateException();
//        array[count] = 0; // by default
        return array[--count];  //array[--count] == 0 }-> this is not necessary.
    }
    public int peek(){
        if(isEmpty())
            throw new IllegalStateException();
        return array[count - 1];
    }
    public boolean isEmpty(){
        return count == 0;
    }
    @Override
    public String toString(){
        var content = Arrays.copyOfRange(array,0, count);
        return Arrays.toString(content);
    }
    public int size(){
        return count;
    }
}
