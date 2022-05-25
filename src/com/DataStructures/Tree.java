package com.DataStructures;

import java.util.ArrayList;

public class Tree {
    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node=" + value;
        }
    }

    private Node root;

    public void insert(int value) {
        var current = root;
        while (true) {
            if (current == null) {
                root = new Node(value);
                return;
            }
            if (value <= current.value) {
                if (current.leftChild == null) {
                    current.leftChild = new Node(value);
                    return;
                }
                current = current.leftChild;
            } else {
                if (current.rightChild == null) {
                    current.rightChild = new Node(value);
                    return;
                }
                current = current.rightChild;
            }
        }
    }

    public boolean find(int value) {
        var current = root;
        while (current != null) {
            if (current.value == value)
                return true;
            else if (current.value >= value)
                current = current.leftChild;
            else
                current = current.rightChild;
        }
        return false;
    }

    public void TraversePreOrder() {
        TraversePreOrder(root);
    }

    private void TraversePreOrder(Node root) {
        if (root == null)
            return;
        System.out.println(root.value);                 //Root
        TraversePreOrder(root.leftChild);               //Left
        TraversePreOrder(root.rightChild);              //Right
    }

    public void InOrder() {
        InOrder(root);
    }

    private void InOrder(Node root) {
        if (root == null)
            return;
        InOrder(root.leftChild);                        //Left
        System.out.println(root.value);                 //Root
        InOrder(root.rightChild);                       //Right
    }

    public void PostOrder() {
        PostOrder(root);
    }

    private void PostOrder(Node root) {
        if (root == null)
            return;
        PostOrder(root.leftChild);                        //Left
        PostOrder(root.rightChild);                       //Right
        System.out.println(root.value);                   //Root
    }

    public int Height() {
        return Height(root);
    }

    //PostOrder
    int sum;
    private int Height(Node root) {
        if (root == null)
            return -1;
        if (root.leftChild == null && root.rightChild == null)
            return 0;
        sum =  1 + Math.max(Height(root.leftChild), Height(root.rightChild));
        return sum;
    }

    public int minValueInBinaryTree() {
        return minValueInBinaryTree(root);
    }

    //PostOrder
    private int minValueInBinaryTree(Node root) {
        if (root.leftChild == null && root.rightChild == null)
            return root.value;
        var left = minValueInBinaryTree(root.leftChild);
        var right = minValueInBinaryTree(root.rightChild);

        return Math.min(Math.min(left, right), root.value);
    }

    public int minValueInBinarySearchTree() {
        if (root == null)
            throw new IllegalStateException();
        var current = root;
        var last = current;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last.value;
    }

    public boolean equals(Tree other) {
        if (other == null)
            return false;
        return equals(root, other.root);
    }

    private boolean equals(Node first, Node second) {
        //1st scenario
        if (first == null && second == null)
            return true;
        //2nd Scenario
        if (first != null && second != null)
            return first.value == second.value
                    && equals(first.leftChild, second.leftChild)
                    && equals(first.rightChild, second.rightChild);
        //3rd Scenario
        return false;
    }

    public boolean validateBinarySearchTree() {
        return validateBinarySearchTree(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    private boolean validateBinarySearchTree(Node root, int left, int right) {
        if (root == null)
            return true;
        if(root.value < left || root.value > right)
            return false;
        return validateBinarySearchTree(root.leftChild, left, root.value - 1)
                && validateBinarySearchTree(root.rightChild, root.value + 1, right);
    }

    //Just to check the above method that is validateBinarySearchTree.
    public void swap(){
        var temp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = temp;
    }
    public ArrayList<Integer> nodesAtKthDistance(int Distance){
        ArrayList<Integer> list = new ArrayList<Integer>();
        nodesAtKthDistance(root,Distance,list);
        return list;
    }
    private void nodesAtKthDistance(Node root, int Distance, ArrayList<Integer> list){
        if(root == null)
            return;
        if(Distance == 0) {
            list.add(root.value);
            return;
        }
        nodesAtKthDistance(root.leftChild,Distance - 1,list);
        nodesAtKthDistance(root.rightChild,Distance - 1,list);
    }
    public void traverseLevelOrder(){
        for(int i = 0; i <= Height();i++){
            for(int value : nodesAtKthDistance(i))
                System.out.println(value);
        }
    }
}