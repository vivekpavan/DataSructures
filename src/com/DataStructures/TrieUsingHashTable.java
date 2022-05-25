package com.DataStructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TrieUsingHashTable {
    private class Node{
        private char value;
        public Node(char value){
            this.value = value;
        }
        private HashMap<Character,Node> children = new HashMap<>();
        private boolean isEndOfWord;
        @Override
        public String toString(){
            return "value = "+value;
        }
        private boolean hasChild(char ch){
            return children.containsKey(ch);
        }
        private void addChild(char ch){
            children.put(ch,new Node(ch));
        }
        private Node getChild(char ch){
            return children.get(ch);
        }
        private Node[] getChildren(){
            return children.values().toArray(new Node[0]);
        }
        private boolean hasChildren(){
            return !children.isEmpty();
        }
        private void removeChild(char ch){
            children.remove(ch);
        }
    }
    private Node root = new Node(' ');
    public void insert(String word){
        Node current = root;
        for(char ch : word.toCharArray()){
            if(!current.hasChild(ch))
                current.addChild(ch);
            current = current.getChild(ch);
        }
        current.isEndOfWord = true;
    }
    public boolean contains(String word){
        if(word == null)
            return false;
        var current = root;
        for(char ch : word.toCharArray()){
            if(!current.hasChild(ch))
                return false;
            current = current.getChild(ch);
        }
        return current.isEndOfWord;
    }

    // In PreOrder first the root node is PRINTED(visited) and then children;
    public void PreOrder(){
        PreOrder(root);
    }
    private void PreOrder(Node root){
        System.out.print(root.value);

        for(Node child : root.getChildren())
            PreOrder(child);
    }
    //In PostOrder First the Child and then the Root node is PRINTED;
    public void PostOrder(){
        PostOrder(root);
    }
    private void PostOrder(Node root){
        for(Node child : root.getChildren())
            PostOrder(child);

        System.out.print(root.value);
    }
    public void Delete(String word){
        if(word == null)
            return;
        Delete(root,word,0);
    }
    //PostOrder traversal
    private void Delete(Node root,String word,int index){
        if(index == word.length()){
            root.isEndOfWord = false;
            return;
        }

       char ch = word.charAt(index);
       Node child = root.getChild(ch);
       if(child == null)
           return;

       Delete(child,word,index+1);

       //ONCE WE RETURN IN BASE CONDITION WE GO ONE STEP BACK SO IN BELOW IF STATEMENT WE ARE PLAYING WITH
        // CHILD AND NOT ROOT.
       if(!child.hasChildren() && !child.isEndOfWord)
           root.removeChild(ch);
    }
    public List<String> AutoComplete(String word){
        List<String> words = new ArrayList<>();
        Node lastNode = lastNodeOf(word);
        AutoComplete(lastNode,word,words);
        return words;
    }
    private Node lastNodeOf(String word){
        if(word == null)
            return null;
        var current = root;
        for(var ch : word.toCharArray()){
            var child = current.getChild(ch);
            if(child == null)
                return null;
            current = child;
        }
        return current;
    }
    //PREORDER TRAVERSAL
    private void AutoComplete(Node root, String word, List<String> words){
        if(root == null)
            return;
        if(root.isEndOfWord)
            words.add(word);
        for(Node child : root.getChildren())
            AutoComplete(child,word + child.value ,words);
    }
}

