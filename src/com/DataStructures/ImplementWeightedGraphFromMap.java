package com.DataStructures;

import java.util.*;
import java.util.Map;

public class ImplementWeightedGraphFromMap {
    private class Node{
        private String label;
        private List<Edge> edges = new ArrayList<>();

        public Node(String label){
            this.label = label;
        }
        public void addEdge(Node to,int weight){
            edges.add(new Edge(this,to,weight));
        }
        public List<Edge> getEdges(){
            return edges;
        }
        @Override
        public String toString(){
            return label;
        }
    }
    private class Edge{
        private Node from;
        private Node to;
        private int weight;
        public Edge(Node from,Node to,int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        @Override
        public String toString(){
            return from + "->" + to;
        }
    }
    private final Map<String,Node> nodes = new HashMap<>();
    public void addNode(String label){
        if(label == null)
            throw new IllegalArgumentException();
        nodes.putIfAbsent(label,new Node(label));
    }
    //adding Edge here According to mosh order
    public void addEdge(String from,String to,int weight){
        if(from == null||to == null)
            throw new IllegalArgumentException();

        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);
        if(!nodes.containsValue(fromNode)||!nodes.containsValue(toNode))
            throw new IllegalArgumentException();
        fromNode.addEdge(toNode,weight);
        toNode.addEdge(fromNode,weight);
    }
    public void print(){
        for(Node node : nodes.values()){
            List<Edge> edges = node.getEdges();
                if(!edges.isEmpty())
                    System.out.println(node +" is connected to " + edges);
            }
    }
    private class nodeEntry{
        private Node node;
        private int priority;

        public nodeEntry(Node node,int priority) {
            this.node = node;
            this.priority = priority;
        }
    }
    public int getShortestDistance(String from,String to){
        PriorityQueue<nodeEntry> queue = new PriorityQueue<>(
                Comparator.comparingInt(ne -> ne.priority)
        );
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);
        Map<Node,Integer> distance = new HashMap<>();

        for(Node node: nodes.values())
            distance.put(node,Integer.MAX_VALUE);
        distance.replace(fromNode,0);

        Set<Node> visited = new HashSet<>();

        queue.add(new nodeEntry(fromNode,0));

        while(!queue.isEmpty()) {
            Node current = queue.remove().node;
            visited.add(current);
            for (Edge edge : current.getEdges()) {
                if(visited.contains(edge.to))
                    continue;

                int distances = distance.get(current) + edge.weight;
                if (distances < distance.get(edge.to)) {
                    distance.replace(edge.to,distances);
                    queue.add(new nodeEntry(edge.to, edge.weight));
                }
            }
        }
        return distance.get(toNode);
    }
    private class Path{
        private List<String> list = new ArrayList<>();
        public void addPath(String node){
            list.add(node);
        }

        @Override
        public String toString() {
            return list.toString();
        }
    }
    public Path getShortPath(String from,String to){
        PriorityQueue<nodeEntry> queue = new PriorityQueue<>(
                Comparator.comparingInt(ne -> ne.priority)
        );
        Node fromNode = nodes.get(from);
        if(fromNode == null)
            throw new IllegalArgumentException();
        Node toNode = nodes.get(to);
        if(toNode == null)
            throw new IllegalArgumentException();

        Map<Node,Integer> distances = new HashMap<>();
        Map<Node,Node> previous = new HashMap<>();

        for(Node node : nodes.values())
            distances.put(node,Integer.MAX_VALUE);

        distances.replace(fromNode,0);

        queue.add(new nodeEntry(fromNode,0));

        Set<Node> visited = new HashSet<>();

        while(!queue.isEmpty()){
            Node current = queue.remove().node;
            visited.add(current);

            for(Edge edge: current.getEdges()){
                if(visited.contains(edge.to))
                    continue;
                int distance = distances.get(current) + edge.weight;
                if(distance  < distances.get(edge.to)) {
                    distances.replace(edge.to, distance);
                    previous.put(edge.to,current);
                    queue.add(new nodeEntry(edge.to,distance));
                }
            }
        }
        return buildPath(previous,toNode);
    }
    private Path buildPath(Map<Node,Node> previous,Node toNode){
        Stack<Node> stack = new Stack<>();
        stack.push(toNode);
        Node previousNode = previous.get(toNode);
        while(previousNode != null){
            stack.push(previousNode);
            previousNode = previous.get(previousNode);
        }
        Path path = new Path();
        while(!stack.isEmpty())
            path.addPath(stack.pop().label);
        return path;
    }
    public boolean hasCycle(){
        Set<Node> visited = new HashSet<>();
        Boolean result = false;
        for(Node node : nodes.values()) {
            if(!visited.contains(node))
                result = hasCycle(node, visited, null);
            if(result)
                return true;
        }
        return false;
    }
    private boolean hasCycle(Node node,Set<Node> visited,Node parent){
        visited.add(node);
        for(Edge edge : node.getEdges()){
            if(edge.to == parent)
                continue;
            if(visited.contains(edge.to))
                return true;
            var result =  hasCycle(edge.to,visited,node);
            if(result)
                return true;
        }
        return false;
    }
    public ImplementWeightedGraphFromMap minimumSpanningTree(){
        ImplementWeightedGraphFromMap tree = new ImplementWeightedGraphFromMap();

        if(nodes.isEmpty())
            return tree;

        PriorityQueue<Edge> edges = new PriorityQueue<>(
                Comparator.comparingInt(e -> e.weight)
        );
        Node startNode = nodes.values().iterator().next();
        edges.addAll(startNode.getEdges());
        tree.addNode(startNode.label);

        if(edges.isEmpty())
            return tree;

        while(tree.nodes.size() < nodes.size()){
            var minEdge = edges.remove();
            var nextNode = minEdge.to;
            if(tree.containsNode(nextNode.label))
                continue;
            tree.addNode(nextNode.label);
            tree.addEdge(minEdge.from.label,nextNode.label, minEdge.weight);

            for(Edge edge : minEdge.to.getEdges()){
                if(!tree.containsNode(edge.to.label))
                    edges.add(edge);
            }
        }
        return  tree;
    }
    public boolean containsNode(String label){
        return nodes.containsKey(label);
    }
    //Repeated again for Practice
    public ImplementWeightedGraphFromMap minSpanningTree(){
        ImplementWeightedGraphFromMap tree = new ImplementWeightedGraphFromMap();

        if(nodes.isEmpty())
            return tree;

        PriorityQueue<Edge> edges = new PriorityQueue<>(
                Comparator.comparingInt(e -> e.weight)
        );

        Node startNode = nodes.values().iterator().next();
        tree.addNode(startNode.label);
        edges.addAll(startNode.getEdges());

        if(edges.isEmpty())
            return tree;

        while(tree.nodes.size() < nodes.size()){
            Edge minEdge = edges.remove();
            Node nextNode = minEdge.to;

            if(tree.containsNode(nextNode.label))
                continue;

            tree.addNode(nextNode.label);
            tree.addEdge(minEdge.from.label,nextNode.label,minEdge.weight);

            for(Edge edge : nextNode.getEdges()){
                if(!tree.containsNode(edge.to.label))
                    edges.add(edge);
            }
        }
        return tree;
    }
}

