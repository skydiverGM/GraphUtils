package com.imaks;

import java.util.HashMap;
import java.util.Map;

public class WeightedGraph<T, W extends Comparable<W>> {
    private Map<T, Map<T, W>> adjList;

    public WeightedGraph() {
        adjList = new HashMap<>();
    }

    public void addVertex(T vertex) {
        adjList.putIfAbsent(vertex, new HashMap<>());
    }

    public void addEdge(T from, T to, W weight) {
        adjList.putIfAbsent(from, new HashMap<>());
        adjList.putIfAbsent(to, new HashMap<>());
        adjList.get(from).put(to, weight);
    }

    public void removeVertex(T vertex) {
        if (!adjList.containsKey(vertex)) return;
        adjList.values().forEach(map -> map.remove(vertex));
        adjList.remove(vertex);
    }

    public void removeEdge(T from, T to) {
        if (adjList.containsKey(from)) {
            adjList.get(from).remove(to);
        }
    }

    public boolean hasVertex(T vertex) {
        return adjList.containsKey(vertex);
    }

    public boolean hasEdge(T from, T to) {
        return adjList.containsKey(from) && adjList.get(from).containsKey(to);
    }

    public W getEdgeWeight(T from, T to) {
        if (hasEdge(from, to)) {
            return adjList.get(from).get(to);
        }
        throw new IllegalArgumentException("Edge" + from + " -> " + to + " doesn't exist.");
    }

    public void setEdgeWeight(T from, T to, W weight) {
        if (hasEdge(from, to)) {
            adjList.get(from).put(to, weight);
        }
        throw new IllegalArgumentException("Edge" + from + " -> " + to + " doesn't exist.");
    }

    public void printGraph() {
        for (Map.Entry<T, Map<T, W>> entry : adjList.entrySet()) {
            System.out.println("Vertex " + entry.getKey() + " -> " + entry.getValue());
        }
    }
}
