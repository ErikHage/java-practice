package com.tfr.collections.collection;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 *
 * Created by Erik Hage on 5/25/2017.
 */
public class TestArrayBasedCollection {

    @Test
    public void test() {
        Collection<String> collection = new ArrayBasedCollection<>();
        collection.add("A");
        collection.add("B");
        collection.add("C");
        collection.add("D");
        collection.add("E");
        collection.add("F");
        assertEquals("A", collection.get("A"));
        assertTrue(collection.contains("A"));
        assertEquals(6, collection.getSize());
        assertTrue(collection.remove("A"));
        assertEquals(5, collection.getSize());
    }


}
