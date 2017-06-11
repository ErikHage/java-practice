package com.tfr.collections.graph;

import com.tfr.collections.queue.Queue;

/**
 *
 * Created by Erik on 6/11/2017.
 */
public interface Graph<T> {

    boolean isEmpty();
    boolean isFull();

    void addVertex(T vertex);

    boolean hasVertex(T vertex);

    void addEdge(T fromVertex, T toVertex);

    Queue<T> getToVertices(T vertex);

    void clearMarks();
    void markVertex(T vertex);
    boolean isMarked(T vertex);
    T getUnmarked();
}
