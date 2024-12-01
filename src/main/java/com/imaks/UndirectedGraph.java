package com.imaks;

import java.util.*;

public class UndirectedGraph<T> {
    private Map<T, List<T>> adjList;

    public UndirectedGraph() {
        adjList = new HashMap<>();
    }

    public void addVertex(T vertex) {
        adjList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(T from, T to) {
        adjList.putIfAbsent(from, new ArrayList<>());
        adjList.putIfAbsent(to, new ArrayList<>());
        adjList.get(to).add(from);
        adjList.get(from).add(to);
    }

    public void removeVertex(T vertex) {
        if (!adjList.containsKey(vertex)) return;
        adjList.values().forEach(neighbors -> neighbors.remove(vertex));
        adjList.remove(vertex);
    }

    public void removeEdge(T from, T to) {
        if (adjList.containsKey(from)) {
            adjList.get(from).remove(to);
        }
        if (adjList.containsKey(to)) {
            adjList.get(to).remove(from);
        }
    }

    public boolean hasVertex(T vertex) {
        return adjList.containsKey(vertex);
    }

    public boolean hasEdge(T from, T to) {
        return adjList.containsKey(from) && adjList.get(from).contains(to);
    }

    public void printGraph() {
        for (Map.Entry<T, List<T>> entry : adjList.entrySet()) {
            System.out.println("Vertex  " + entry.getKey() + " -> " + entry.getValue());
        }
    }
}
