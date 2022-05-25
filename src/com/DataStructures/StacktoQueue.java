package com.DataStructures;

import java.util.Stack;

public class StacktoQueue {
    private final Stack<Integer> stack1 = new Stack<>();
    private final Stack<Integer> stack2 = new Stack<>();

    public void enqueue(int number){
        stack1.push(number);
    }
    public int dequeue(){
        if(isEmpty())
            throw new IllegalStateException();

        moveStack1toStack2();

        return stack2.pop();
    }

    private void moveStack1toStack2() {
        if(stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }
    // PEEK OF QUEUE IS THE ELEMENT WHICH MOVES OUT OF THE QUEUE NEXT , SIMILARLY LOGIC FOR STACK.
    public int peek(){
        if(isEmpty())
            throw new IllegalStateException();

        moveStack1toStack2();

        return stack2.peek();
    }
    public boolean isEmpty(){
        return stack1.isEmpty() && stack2.isEmpty();
    }

}
