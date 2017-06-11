package com.tfr.collections.graph;

import com.google.common.collect.Sets;
import com.tfr.collections.queue.Queue;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

/**
 *
 *
 * Created by Erik on 6/10/2017.
 */
public class TestArrayBasedWeightedGraph {

    private ArrayBasedWeightedGraph<String> graph;

    private String nyc = "New York";
    private String mn = "Minneapolis";
    private String den = "Denver";
    private String bis = "Bismarck";

    @Before
    public void setUp() {
        graph = new ArrayBasedWeightedGraph<>();

        graph.addVertex(nyc);
        graph.addVertex(mn);
        graph.addVertex(den);
        graph.addVertex(bis);

        graph.addEdge(nyc, mn, 1500);
        graph.addEdge(mn, nyc, 1500);
        graph.addEdge(mn, den, 800);
        graph.addEdge(den, mn, 800);
        graph.addEdge(nyc, den, 2400);
        graph.addEdge(den, nyc, 2400);
        graph.addEdge(mn, bis, 500);
        graph.addEdge(bis, mn, 500);
    }

    @Test
    public void testWeightIs() {
        assertEquals(1500, graph.weightIs(nyc, mn));
        assertEquals(800, graph.weightIs(den, mn));
        assertEquals(2400, graph.weightIs(nyc, den));
        assertEquals(500, graph.weightIs(bis, mn));
    }

    @Test
    public void testHasVertex() {
        assertTrue(graph.hasVertex(nyc));
        assertFalse(graph.hasVertex("Test"));
    }

    @Test
    public void testIsEmpty() {
        ArrayBasedWeightedGraph<String> graph1 = new ArrayBasedWeightedGraph<>();
        assertTrue(graph1.isEmpty());
        graph1.addVertex("Test");
        assertFalse(graph1.isEmpty());
    }

    @Test
    public void testIsFull() {
        ArrayBasedWeightedGraph<String> graph1 = new ArrayBasedWeightedGraph<>(1);
        assertFalse(graph1.isFull());
        graph1.addVertex("Test");
        assertTrue(graph1.isFull());
    }

    @Test
    public void testGetToVertices() {
        Set<String> expectedToVertices = Sets.newHashSet(bis, den, nyc);
        Queue<String> toVertices = graph.getToVertices(mn);
        assertEquals(3, toVertices.getSize());
        while(!toVertices.isEmpty()) {
            String s = toVertices.dequeue();
            assertTrue(expectedToVertices.contains(s));
            expectedToVertices.remove(s);
        }
    }

    @Test
    public void testIsMarked() {
        assertFalse(graph.isMarked(nyc));
        graph.markVertex(nyc);
        assertTrue(graph.isMarked(nyc));
    }

    @Test
    public void testClearMarks() {
        graph.markVertex(nyc);
        assertTrue(graph.isMarked(nyc));
        graph.clearMarks();
        assertFalse(graph.isMarked(nyc));
    }

    @Test
    public void testGetUnmarked() {
        graph.markVertex(nyc);
        graph.markVertex(den);
        graph.markVertex(mn);
        String unmarked = graph.getUnmarked();
        assertEquals(bis, unmarked);
        graph.markVertex(bis);
        assertNull(graph.getUnmarked());
    }

}
