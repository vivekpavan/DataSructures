package com.DataStructures;

public class avlTrees {
    private class avlNode{
        private int height;
        private int value;
        private avlNode leftChild;
        private avlNode rightChild;
        public avlNode(int value){
            this.value = value;
        }
        @Override
        public String toString(){
            return "value" + this.value;
        }
    }
    private avlNode root;
    public void insert(int value){
        root = insert(root,value);
    }
    private avlNode insert(avlNode root,int value){
        if(root == null) {
            root = new avlNode(value);
            return root;
        }
        if(value  < root.value)
            root.leftChild = insert(root.leftChild,value);
        else
            root.rightChild = insert(root.rightChild,value);

        root.height = Math.max(height(root.leftChild),height(root.rightChild)) + 1;

        root = balance(root);

        return root;
    }
    private int height(avlNode node){
        if(node == null)
            return -1;
        return node.height;
    }
    private boolean isLeftHeavy(avlNode node){
        return BalanceFactor(node) > 1;
    }
    private boolean isRightHeavy(avlNode node){
        return BalanceFactor(node) < -1;
    }
    private int BalanceFactor(avlNode node){
        return (node == null) ? 0  : height(node.leftChild) - height(node.rightChild);
    }
    private avlNode balance(avlNode root){
        avlNode newroot = root;
        if(isLeftHeavy(root)) {
            newroot = root.leftChild;
            if (BalanceFactor(root.leftChild) < 0) {
                newroot = newroot.rightChild;
                newroot.leftChild = root.leftChild;
                root.leftChild = newroot;
            }
            root.leftChild = newroot.rightChild;
            newroot.rightChild = root;
            root.height = Math.max(height(root.leftChild),height(root.rightChild)) + 1;         //revising the heights
            newroot.height = Math.max(height(root.leftChild),height(root.rightChild)) + 1;      //revising the heights
        }
        else if(isRightHeavy(root)){
            newroot = root.rightChild;
            if(BalanceFactor(root.rightChild) > 0) {
                newroot = newroot.leftChild;
                newroot.rightChild = root.rightChild;
                root.rightChild = newroot;
            }
            root.rightChild = newroot.leftChild;
            newroot.leftChild = root;
            root.height = Math.max(height(root.leftChild),height(root.rightChild)) + 1;         //revising the heights
            newroot.height = Math.max(height(root.leftChild),height(root.rightChild)) + 1;      //revising the heights
        }
        return newroot;
    }
}
