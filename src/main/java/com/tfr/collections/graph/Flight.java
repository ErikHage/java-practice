package com.tfr.collections.graph;

/**
 *
 * Created by Erik on 6/14/2017.
 */
public class Flight<T> implements Comparable<Flight<T>> {

    private T fromVertex;
    private T toVertex;
    private int distance;

    public Flight(T fromVertex, T toVertex, int distance) {
        this.fromVertex = fromVertex;
        this.toVertex = toVertex;
        this.distance = distance;
    }

    @Override
    public int compareTo(Flight<T> other) {
        return other.distance - this.distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight<?> flight = (Flight<?>) o;

        if (distance != flight.distance) return false;
        if (!fromVertex.equals(flight.fromVertex)) return false;
        return toVertex.equals(flight.toVertex);
    }

    @Override
    public int hashCode() {
        int result = fromVertex.hashCode();
        result = 31 * result + toVertex.hashCode();
        result = 31 * result + distance;
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s          %s          %s", fromVertex, toVertex, distance);
    }

    public T getFromVertex() {
        return fromVertex;
    }

    public void setFromVertex(T fromVertex) {
        this.fromVertex = fromVertex;
    }

    public T getToVertex() {
        return toVertex;
    }

    public void setToVertex(T toVertex) {
        this.toVertex = toVertex;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
