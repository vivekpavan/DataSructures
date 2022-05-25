package com.DataStructures;

public class TrieUsingArray {
    public static int ALPHABET_SIZE = 26;
    private Node root = new Node(' ');
    private class Node{
        private char value;
        public Node(char value){
            this.value = value;
        }
        private Node[] children = new Node[ALPHABET_SIZE];
        private boolean isEndOfWord;

        @Override
        public String toString(){
            return "value "+value;
        }
    }
    public void insert(String word){
        var array = word.toCharArray();
        int index;
        var current = root;
        int count = 0;
        for(char ch : array){
            index = ch - 'a';
            if(current.children[index] != null){
                current = current.children[index];
                count++;
                continue;
            }
            var node = new Node(ch);
            current.children[index] = node;
            current = node;
            count++;
            if(count == array.length)
                node.isEndOfWord = true;
        }
    }
}
