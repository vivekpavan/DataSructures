package com.DataStructures;

import java.util.Arrays;

public class ArraytoCircularQueue {
    private final int[] array;
    public ArraytoCircularQueue(int size){
        array = new int[size];
    }
    private int front;
    private int rear;
    private int count;
    public void enqueue(int number){
        if(isFull())
            throw new IllegalStateException();
        array[rear] = number;
        rear = (rear + 1) % array.length;           //circular array implementation.
        count++;
    }
    public int dequeue(){
        if(isEmpty())
            throw new IllegalStateException();
        var item = array[front];
        array[front] = 0;
        front = (front + 1) % array.length;         //circular array implementation.
        count--;
        return item;
    }
    //the front element is peek in Queue because front/(first) element is what we remove first.
    public int peek(){
        return array[front];
    }
    //We use count for isFull() and isEmpty() methods only;
    public boolean isEmpty(){
        return count == 0;
    }
    public boolean isFull(){
        return count == array.length;
    }
    @Override
    public String toString(){
//        var content = Arrays.copyOfRange(array,front,rear);
        return Arrays.toString(array);
    }
}
