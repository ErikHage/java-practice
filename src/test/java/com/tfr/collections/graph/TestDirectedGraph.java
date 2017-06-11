package com.tfr.collections.graph;

import com.google.common.collect.Sets;
import com.tfr.collections.queue.Queue;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

/**
 *
 * Created by Erik on 6/11/2017.
 */
public class TestDirectedGraph {

    private DirectedAdjacencyGraph<String> graph;

    private String newNewTrade = "New/NewTrade";
    private String amendCorrection = "Amend/Correction";
    private String amendAdmin = "Amend/Admin";
    private String terminateCancel = "Terminate/Cancel";

    @Before
    public void setUp() {
        graph = new DirectedAdjacencyGraph<>(10);

        graph.addVertex(newNewTrade);
        graph.addVertex(amendCorrection);
        graph.addVertex(amendAdmin);
        graph.addVertex(terminateCancel);

        graph.addEdge(newNewTrade, amendAdmin);
        graph.addEdge(newNewTrade, amendCorrection);
        graph.addEdge(newNewTrade, terminateCancel);

        graph.addEdge(amendAdmin, amendCorrection);
        graph.addEdge(amendAdmin, amendAdmin);
        graph.addEdge(amendAdmin, terminateCancel);

        graph.addEdge(amendCorrection, amendAdmin);
        graph.addEdge(amendCorrection, amendCorrection);
        graph.addEdge(amendCorrection, terminateCancel);

        graph.addEdge(terminateCancel, terminateCancel);
    }

    @Test
    public void testHasVertex() {
        assertTrue(graph.hasVertex(newNewTrade));
        assertFalse(graph.hasVertex("Test"));
    }

    @Test
    public void testIsEmpty() {
        DirectedAdjacencyGraph<String> graph1 = new DirectedAdjacencyGraph<>(1);
        assertTrue(graph1.isEmpty());
        graph1.addVertex(newNewTrade);
        assertFalse(graph1.isEmpty());
    }

    @Test
    public void testIsFull() {
        DirectedAdjacencyGraph<String> graph1 = new DirectedAdjacencyGraph<>(1);
        assertFalse(graph1.isFull());
        graph1.addVertex(newNewTrade);
        assertTrue(graph1.isFull());
    }

    @Test
    public void testGetToVertices() {
        Set<String> expectedSet = Sets.newHashSet(amendAdmin, amendCorrection, terminateCancel);
        Queue<String> toVertices = graph.getToVertices(amendAdmin);
        assertEquals(3, toVertices.getSize());
        while(!toVertices.isEmpty()) {
            String s = toVertices.dequeue();
            assertTrue(expectedSet.contains(s));
            expectedSet.remove(s);
        }
    }

    @Test
    public void testIsMarked() {
        assertFalse(graph.isMarked(newNewTrade));
        graph.markVertex(newNewTrade);
        assertTrue(graph.isMarked(newNewTrade));
    }

    @Test
    public void testClearMarks() {
        assertFalse(graph.isMarked(newNewTrade));
        graph.markVertex(newNewTrade);
        assertTrue(graph.isMarked(newNewTrade));
        graph.clearMarks();
        assertFalse(graph.isMarked(newNewTrade));
    }

    @Test
    public void testGetUnmarked() {
        graph.markVertex(newNewTrade);
        graph.markVertex(amendAdmin);
        graph.markVertex(amendCorrection);
        String unmarked = graph.getUnmarked();
        assertEquals(terminateCancel, unmarked);
        graph.markVertex(terminateCancel);
        assertNull(graph.getUnmarked());
    }

}
