package com.tfr.collections.graph;

import com.tfr.collections.priorityQueue.HeapPriorityQueue;
import com.tfr.collections.priorityQueue.PriorityQueue;
import com.tfr.collections.queue.LinkedQueue;
import com.tfr.collections.queue.Queue;
import com.tfr.collections.stack.LinkedStack;
import com.tfr.collections.stack.Stack;

/**
 *
 * Created by Erik on 6/13/2017.
 */
public class GraphUtils {

    public static <T> boolean isPathDF(WeightedGraph<T> graph, T startVertex, T endVertex) {
        Stack<T> stack = new LinkedStack<>();
        Queue<T> queue;

        boolean found = false;
        T currentVertex;
        T adjacentVertex;

        graph.clearMarks();
        graph.markVertex(startVertex);
        stack.push(startVertex);

        do {
            currentVertex = stack.top();
            stack.pop();
            System.out.println(currentVertex);
            if(currentVertex.equals(endVertex)) {
                found = true;
            } else {
                queue = graph.getToVertices(currentVertex);
                while(!queue.isEmpty()) {
                    adjacentVertex = queue.dequeue();
                    if(!graph.isMarked(adjacentVertex)) {
                        graph.markVertex(adjacentVertex);
                        stack.push(adjacentVertex);
                    }
                }
            }
        }while(!stack.isEmpty()  && !found);

        return found;
    }


    public static <T> boolean isPathBF(WeightedGraph<T> graph, T startVertex, T endVertex) {
        Queue<T> todoQueue = new LinkedQueue<>();
        Queue<T> queue;

        boolean found = false;
        T currentVertex;
        T adjacentVertex;

        graph.clearMarks();
        graph.markVertex(startVertex);
        todoQueue.enqueue(startVertex);

        do {
            currentVertex = todoQueue.dequeue();
            System.out.println(currentVertex);
            if(currentVertex.equals(endVertex)) {
                found = true;
            } else {
                queue = graph.getToVertices(currentVertex);
                while(!queue.isEmpty()) {
                    adjacentVertex = queue.dequeue();
                    if(!graph.isMarked(adjacentVertex)) {
                        graph.markVertex(adjacentVertex);
                        todoQueue.enqueue(adjacentVertex);
                    }
                }
            }
        }while(!todoQueue.isEmpty()  && !found);

        return found;
    }

    public static <T> void shortestPaths(WeightedGraph<T> graph, T startVertex) {
        Flight<T> flight;
        Flight<T> saveFlight;
        int minDistance;
        int newDistance;

        PriorityQueue<Flight<T>> priorityQueue = new HeapPriorityQueue<>(20);
        T vertex;
        Queue<T> vertexQueue;

        graph.clearMarks();
        saveFlight = new Flight<>(startVertex, startVertex, 0);
        priorityQueue.enqueue(saveFlight);

        System.out.println("Last Vertex  Destination  Distance");
        System.out.println("-----------------------------------");

        do {
            flight = priorityQueue.dequeue();
            if(!graph.isMarked(flight.getToVertex())) {
                graph.markVertex(flight.getToVertex());
                System.out.println(flight);
                flight.setFromVertex(flight.getToVertex());
                minDistance = flight.getDistance();
                vertexQueue = graph.getToVertices(flight.getFromVertex());
                while(!vertexQueue.isEmpty()) {
                    vertex = vertexQueue.dequeue();
                    if(!graph.isMarked(vertex)) {
                        newDistance = minDistance + graph.weightIs(flight.getFromVertex(), vertex);
                        saveFlight = new Flight<>(flight.getFromVertex(), vertex, newDistance);
                        priorityQueue.enqueue(saveFlight);
                    }
                }
            }
        } while(!priorityQueue.isEmpty());

        System.out.println("\nThe unreachable vertices are: ");
        vertex = graph.getUnmarked();
        while(vertex != null) {
            System.out.println(vertex);
            graph.markVertex(vertex);
            vertex = graph.getUnmarked();
        }
    }
}
