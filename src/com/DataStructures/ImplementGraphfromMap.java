package com.DataStructures;

import java.util.*;
import java.util.Map;
import java.util.Queue;

public class ImplementGraphfromMap {
    private class Node{
        private String label;
        public Node(String label){
            this.label = label;
        }
        @Override
        public String toString(){
            return label;
        }
    }
    private final Map<String,Node> nodes = new HashMap<>();
    private final Map<Node, List<Node>> adjacencyList  = new HashMap<>();

    public void addNode(String label){
        Node node = new Node(label);
        nodes.putIfAbsent(label,node);
        adjacencyList.putIfAbsent(node,new ArrayList<>());
    }
    //IN THIS IMPLEMENTATION FROM IS THE TARGET AND TO IS THE ROOT NODE(SO WE ARE ADDING FROM to TO)
    //THE FROM AND TO ARE IN OPPOSITE ORDER TO THAT OF MOSH.
    public void addEdge(String from,String to){
        var toNode = nodes.get(to);
        if(!nodes.containsKey(to))
            throw new IllegalArgumentException();
        var fromNode = nodes.get(from);
        if(!nodes.containsKey(from))
            throw new IllegalArgumentException();
        adjacencyList.get(toNode).add(fromNode);  //Single_Directed or Uni_Directed
    }
    public void removeNode(String label) {
        Node node = nodes.get(label);
        if (node == null)                     // if(nodes.containsKey(label))
            return;
        for (Node n : adjacencyList.keySet())
            adjacencyList.get(n).remove(node);
        adjacencyList.remove(node);
        nodes.remove(label);
    }

    //IN THIS IMPLEMENTATION FROM IS THE TARGET AND TO IS THE ROOT NODE(SO WE ARE Removing FROM from TO)
    public void removeEdge(String from,String to){
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);
        if(fromNode == null || toNode == null)
            return;
        adjacencyList.get(toNode).remove(fromNode);
    }
    public void print(){
        for(Node source : adjacencyList.keySet()){
            List<Node> targets = adjacencyList.get(source);
            if(!targets.isEmpty())
                System.out.println(source + " is connected to " + targets);
        }
    }
    //this method does not take any String from user but the loop calls each node and implements it seperately;
    //with respect to the context asked the implementation is wrong.
    public void dfsRecursive(){
        HashSet<Node> set = new HashSet<>();
        Queue<Node> q = new ArrayDeque<>();
        for(var n : adjacencyList.keySet())
            dfsRecursive(n,set,q);
        System.out.println(q);
    }
    private void dfsRecursive(Node node,HashSet<Node> set,Queue<Node> q){
        if(!set.contains(node)) {
            set.add(node);
            q.add(node);
        }
        for(var m : adjacencyList.get(node)) {
            if(!set.contains(m))
                q.add(m);
            set.add(m);
            dfsRecursive(m,set,q);
        }
    }

    public void dfsRecurse(String root){
        if(nodes.get(root) == null)
            return;
        dfsRecurse(nodes.get(root),new HashSet<>());
    }
    private void dfsRecurse(Node root,Set<Node> visited){
        System.out.print(root);
        visited.add(root);
        for(Node node : adjacencyList.get(root))
            if(!visited.contains(node))
                dfsRecurse(node,visited);
    }
    //stack -> dfs
    public void dfsIterative(String root){
        Node node = nodes.get(root);
        if(node == null)
            return;
        Set<Node> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()){
            Node current = stack.pop();

            if(visited.contains(current))
                continue;

            System.out.print(current);
            visited.add(current);

            for(Node n : adjacencyList.get(current))
                if(!visited.contains(n))
                    stack.push(n);
        }
    }

    //queue -> bfs
    public void bfsIterative(String root){
        Node node = nodes.get(root);
        if(node == null)
            return;
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new ArrayDeque<>();

        queue.add(node);
        while(!queue.isEmpty()){
            Node current = queue.remove();

            if(visited.contains(current))
                continue;

            System.out.print(current);
            visited.add(current);

            for(Node n : adjacencyList.get(current))
                if(!visited.contains(n))
                    queue.add(n);
        }
    }
    public List<String> TopologicalSort(){
        Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet<>();
        for(Node node : nodes.values())
            TopologicalSort(node,visited,stack);
        List<String> list = new ArrayList<>();
        while(!stack.empty())
            list.add(stack.pop().label);
        return list;
    }
    private void TopologicalSort(Node node,Set<Node> visited,Stack<Node> stack){
        if(visited.contains(node))
            return;
        visited.add(node);
        for(Node n : adjacencyList.get(node)){
            TopologicalSort(n,visited,stack);
        }
        stack.push(node);
    }
    public boolean hasCycle(){
        Set<Node> all =new HashSet<>();
        all.addAll(nodes.values());

        Set<Node> visiting =new HashSet<>();
        Set<Node> visited =new HashSet<>();

        while(!all.isEmpty()) {
            Node node = all.iterator().next();
            if(hasCycle(node, all, visiting, visited))
                return true;
        }
        return false;
    }
    private boolean hasCycle(Node node,Set<Node> all,Set<Node> visiting ,Set<Node> visited){
        all.remove(node);
        visiting.add(node);
        for(var neighbour : adjacencyList.get(node)){
            if(visited.contains(neighbour))
                continue;

            if(visiting.contains(neighbour))
                return true;

            if(hasCycle(neighbour,all,visiting,visited))
                return true;
        }
        visiting.remove(node);
        visited.add(node);

        return false;
    }
}
