package com.DataStructures;

import java.util.Arrays;
import java.util.Stack;

public class Queue {
    public void reverse(java.util.Queue<Integer> queue){
        Stack<Integer> stack = new Stack<>();
        while(!queue.isEmpty())
            stack.push(queue.remove());
        while(!stack.isEmpty())
            queue.add((stack.pop()));
    }
}
