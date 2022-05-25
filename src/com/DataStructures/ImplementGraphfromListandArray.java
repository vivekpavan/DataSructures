package com.DataStructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ImplementGraphfromListandArray {
    private class Node{
        private String label;
        public Node(String label){
            this.label = label;
        }
        private String[] children = new String[10];
    }
    private List<Node> list = new ArrayList<>();
    public void addNode(String label){
        var node = new Node(label);
        if(list.contains(node))
            return;
        list.add(node);
    }
    public void removeNode(String label){
        Node remove = null;
        int index = 0;
        for(Node node : list){
            if(Objects.equals(node.label, label))
                remove = node;
            while(remove != node && node.children[index] != null) {
                if (node.children[index++].equals(label))
                    node.children[index] = null;
            }
            index = 0;
        }
        list.remove(remove);
    }
    //IN THIS IMPLEMENTATION FROM IS THE TARGET AND TO IS THE ROOT NODE(SO WE ARE ADDING FROM to TO)

    public void addEdge(String from,String to){
        int index = 0;
        for(Node node : list) {
            if (Objects.equals(node.label, to))
                while (true) {
                    if (node.children[index] == null) {
                        node.children[index] = from;
                        break;
                    }
                    index++;
                }
        }
    }
    public void removeEdge(String from,String to){
        int index = 0;
        for(Node node : list){
            if(Objects.equals(node.label, to))
                while(true) {
                    if (Objects.equals(node.children[index], from)) {
                        node.children[index] = null;
                        break;
                    }
                    index++;
                }
        }
    }
    public void print(){
        for(Node node : list){
            System.out.println(node.label + "is connected to"+ Arrays.toString(node.children));
        }
    }
}
