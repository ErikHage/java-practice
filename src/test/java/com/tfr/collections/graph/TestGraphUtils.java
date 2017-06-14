package com.tfr.collections.graph;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 *
 * Created by Erik on 6/13/2017.
 */
public class TestGraphUtils {

    private WeightedGraph<String> graph;

    private String NYC = "NYC";
    private String FLO = "FLO";
    private String AUS = "AUS";
    private String LAX = "LAX";
    private String SEA = "SEA";
    private String WAS = "WAS";

    @Before
    public void setUp() {
        graph = new ArrayBasedWeightedGraph<>();

        graph.addVertex(NYC);
        graph.addVertex(FLO);
        graph.addVertex(AUS);
        graph.addVertex(LAX);
        graph.addVertex(SEA);
        graph.addVertex(WAS);

        graph.addEdge(NYC, FLO, 1200);
        graph.addEdge(NYC, LAX, 3200);
        graph.addEdge(NYC, AUS, 2200);

        graph.addEdge(FLO, NYC, 1200);
        graph.addEdge(FLO, LAX, 3400);

        graph.addEdge(AUS, LAX, 2000);

        graph.addEdge(LAX, AUS, 2000);
        graph.addEdge(LAX, SEA, 1000);
        graph.addEdge(LAX, NYC, 3200);

        graph.addEdge(SEA, LAX, 1000);
        graph.addEdge(SEA, NYC, 3000);
    }

    @Test
    public void testIsPathDF() {
        assertTrue(GraphUtils.isPathDF(graph, NYC, FLO));
        assertFalse(GraphUtils.isPathDF(graph, NYC, WAS));
    }

    @Test
    public void testIsPathBF() {
        assertTrue(GraphUtils.isPathBF(graph, NYC, FLO));
        assertFalse(GraphUtils.isPathBF(graph, NYC, WAS));
    }

    @Test
    public void testShortestPath() {
        GraphUtils.shortestPaths(graph, NYC);
    }

}
