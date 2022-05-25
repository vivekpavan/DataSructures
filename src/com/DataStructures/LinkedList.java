package com.DataStructures;

import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        public int value;
        public Node next;
        public Node(int value){
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public void addLast(int value){
        Node node = new Node(value);
        if(isEmpty())
            first = last = node;
        else{
            last.next = node;
            last = node;
        }
        size++;
    }
    public void addFirst(int value){
        Node node = new Node(value);
        if(isEmpty())
            first = last = node;
        else{
            node.next = first;
            first = node;
        }
        size++;
    }
    private boolean isEmpty(){
        return first == null;
    }
    public int indexOf(int item){
        int index = 0;
        Node current = first;
        while(current != null){
            if(current.value == item) return index;
            current = current.next;
            index++;
        }
        return -1;
    }
    public boolean contains(int item) {
        return indexOf(item) != -1;
    }
    public void removeFirst(){
        if(isEmpty())
            throw new NoSuchElementException();
        if(first == last){
            first = last = null;
            size--;
            return;
        }
        var second = first.next;
        first.next = null;
        first = second;
        size--;
    }
    public void removeLast(){
        if(isEmpty())
            throw new NoSuchElementException();
        if(first == last){
            first = last = null;
            size--;
            return;
        }
        Node previous = get_Previous(last);
        last = previous;
        last.next = null;
        size--;
    }
    private Node get_Previous(Node node){
        Node current = first;
        while(current != null){
            if(current.next == node)
                return current;
            current = current.next;
        }
        return null;
    }
    public int size(){
        return size;
//        below method also implements size but each time we call this method we have to traverse the entire list.
//        int count = 0;
//        if(isEmpty())
//            return count;
//        var current = first;
//        while(current != null) {
//            current = current.next;
//            count++;
//        }
//        return count;
    }
    public int[] toArray(){
        int[] array = new int[size];
        if(isEmpty())
            return new int[0];
        var current= first;
        int index = 0;
            while (current != null) {
                array[index++] = current.value;
                current = current.next;
            }
        return array;
    }
    public void reverse(){
        if(isEmpty()) return;
        var current = last;
        var note = current;
        Node previous;
        while(current != first){
            previous = get_Previous(current);                 //O(n)
            current.next = previous;
            current = previous;
        }                                                  // = O(n) => So not efficient comparetivly

        last = current;
        last.next = null;
        first = note;

    }
    public void reverser(){
        if(isEmpty())
            return;
        var previous = first;
        var current = previous.next;
        while(current != null){
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }                                                   // O(1) => So efficient algorithm.
        last = first;
        last.next = null;
        first = previous;
    }
    public int getKthFromEnd(int k){
        if(isEmpty() || k > size())
            throw  new IllegalArgumentException();
        var one = first;
        var second = first;
        for(var i = 0;i < k - 1;i++){
            second = second.next;
        }
        while(second != last) {
            second = second.next;
            one = one.next;
        }
        return one.value;
    }
}
