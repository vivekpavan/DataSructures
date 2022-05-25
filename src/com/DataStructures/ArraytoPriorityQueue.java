package com.DataStructures;

import java.util.Arrays;

public class ArraytoPriorityQueue {
    int[] array;
    public ArraytoPriorityQueue(int size){
        array = new int[size];
    }
    private int front;      // 1st pointer
    private int rear;       // 2nd pointer
    private int count;      // for tracking number of elements in array
    private int iterate;
    public void insert(int number){
        if(isFull())
            throw new IllegalStateException();
        if (rear == 0){
            array[rear++] = number;
            count++;
        }
        else {
            while (true) {
                if (rear>0 && number <= array[rear - 1]) {
                    array[rear] = array[rear - 1];
                    rear = rear - 1;
                    continue;
                }
                if(rear <= 0) {
                    rear = 0;
                    iterate++;
                }
                if(iterate > 0 || number >= array[rear - 1]){
                    array[rear] = number;
                    break;
                }
            }
            count++;
            rear = count;
        }
    }
    public int remove(){
        if(isEmpty())
            throw new IllegalStateException();
        int temp = array[front];
        array[front++] = 0;
        return temp;
    }
    public int peek(){
        if(isEmpty())
            throw new IllegalStateException();
        return array[front];
    }
    @Override
    public String toString(){
        int[] content = Arrays.copyOfRange(array,front,rear);
        return Arrays.toString(array);
    }
    public boolean isFull(){
        return count == array.length;
    }
    public boolean isEmpty(){
        return front == array.length;
    }
}
