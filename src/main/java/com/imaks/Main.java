package com.imaks;

public class Main {
    public static void main(String[] args) {
        //UndirectedGraph graph = new UndirectedGraph();
        DirectedGraph<String> graph = new DirectedGraph<>();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "A");
        graph.addEdge("E", "A");
        graph.addEdge("D", "C");
        graph.addEdge("C", "C");

        System.out.println("Initial graph:");
        graph.printGraph();

        System.out.println("\nRemove edge A -> C:");
        graph.removeEdge("A", "C");
        graph.printGraph();

        System.out.println("\nRemove C:");
        graph.removeVertex("C");
        graph.printGraph();

        System.out.println("\nHas vertex A: " + graph.hasVertex("A"));
        System.out.println("Has edge A -> C: " + graph.hasEdge("A", "C"));
    }
}