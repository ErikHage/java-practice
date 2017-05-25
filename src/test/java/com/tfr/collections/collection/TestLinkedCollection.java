package com.tfr.collections.collection;

import com.tfr.collections.collection.Collection;
import com.tfr.collections.collection.LinkedCollection;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 *
 * Created by Erik Hage on 5/25/2017.
 */
public class TestLinkedCollection {

    @Test
    public void test() {

        Collection<String> collection = new LinkedCollection<>();

        collection.add("A");
        collection.add("B");
        collection.add("C");

        assertEquals(3, collection.getSize());

        System.out.println(collection.toString());

        assertTrue(collection.contains("C"));
        assertTrue(collection.contains("A"));
        assertTrue(collection.contains("B"));

        assertTrue(collection.remove("A"));

        assertEquals(2, collection.getSize());
        assertTrue(!collection.contains("A"));

        assertTrue(collection.remove("C"));
        assertTrue(collection.remove("B"));

        assertEquals(0, collection.getSize());
    }

}
