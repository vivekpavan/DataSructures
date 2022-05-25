package com.DataStructures;

public class PriorityQueuewithHeap {
    private Heap heap = new Heap();

    public void enqueue(int item){
        heap.insert(item);
    }
    public int delete(){
        return heap.remove();
    }
}
