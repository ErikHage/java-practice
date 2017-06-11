package com.tfr.collections.graph;

import com.tfr.collections.queue.LinkedQueue;
import com.tfr.collections.queue.Queue;

/**
 *
 * Created by Erik on 6/10/2017.
 */
@SuppressWarnings("unchecked")
public class ArrayBasedWeightedGraph<T> implements WeightedGraph<T> {

    public static final int NULL_EDGE = 0;
    private static final int DEFAULT_CAPACITY = 50;

    private int numberOfVertices;
    private int maxVertices;

    private T[] vertices;
    private int[][] edges;

    private boolean[] marks;

    public ArrayBasedWeightedGraph() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayBasedWeightedGraph(int maxVertices) {
        this.numberOfVertices = 0;
        this.maxVertices = maxVertices;
        this.vertices = (T[]) new Object[maxVertices];
        this.marks = new boolean[maxVertices];
        this.edges = new int[maxVertices][maxVertices];
    }

    @Override
    public boolean isEmpty() {
        return numberOfVertices == 0;
    }

    @Override
    public boolean isFull() {
        return numberOfVertices == maxVertices;
    }

    @Override
    public void addVertex(T vertex) {
        if(isFull()) {
            throw new GraphOverflowException("Cannot add vertex to a full graph");
        }
        vertices[numberOfVertices] = vertex;
        for(int index=0; index<numberOfVertices; index++) {
            edges[numberOfVertices][index] = NULL_EDGE;
            edges[index][numberOfVertices] = NULL_EDGE;
        }
        numberOfVertices++;
    }

    private int indexIs(T vertex) {
        int index = 0;
        while(!vertex.equals(vertices[index])) {
            index++;
        }
        return index;
    }

    @Override
    public boolean hasVertex(T vertex) {
        for(int i=0; i<numberOfVertices; i++) {
            if(vertices[i].equals(vertex)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void addEdge(T fromVertex, T toVertex, int weight) {
        int row;
        int column;

        row = indexIs(fromVertex);
        column = indexIs(toVertex);

        edges[row][column] = weight;
    }

    @Override
    public int weightIs(T fromVertex, T toVertex) {
        int row;
        int column;

        row = indexIs(fromVertex);
        column = indexIs(toVertex);

        return edges[row][column];
    }

    @Override
    public Queue<T> getToVertices(T vertex) {
        Queue<T> queue = new LinkedQueue<>();

        int fromIndex = indexIs(vertex);
        int toIndex;

        for(toIndex=0; toIndex<numberOfVertices; toIndex++) {
            if(edges[fromIndex][toIndex] != NULL_EDGE) {
                queue.enqueue(vertices[toIndex]);
            }
        }

        return queue;
    }

    @Override
    public void clearMarks() {
        marks = new boolean[maxVertices];
    }

    @Override
    public void markVertex(T vertex) {
        int index = indexIs(vertex);
        marks[index] = true;
    }

    @Override
    public boolean isMarked(T vertex) {
        int index = indexIs(vertex);
        return marks[index];
    }

    @Override
    public T getUnmarked() {
        for(int i=0; i<numberOfVertices; i++) {
            if(!marks[i]) {
                return vertices[i];
            }
        }
        return null;
    }

}
