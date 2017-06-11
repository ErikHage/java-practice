package com.tfr.collections.map;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 *
 * Created by Erik on 6/8/2017.
 */
public class TestHashMap {

    @Test
    public void test() {
        Map<String, Integer> map = new HashMap<>();

        assertTrue(map.isEmpty());

        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.put("D", 4);
        map.put("E", 5);
        map.put("F", 6);

        assertFalse(map.isEmpty());
        assertEquals(6, map.getSize());

        assertEquals(1, (int)map.get("A"));
        assertEquals(5, (int)map.get("E"));

        assertTrue(map.contains("E"));

        assertEquals(1, (int)map.put("A", 10));
        assertEquals(10, (int)map.get("A"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testPut_ExpectIllegalArgumentException() {
        new HashMap<>().put(null, 1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGet_ExpectIllegalArgumentException() {
        new HashMap<>().get(null);
    }

    @Test (expected = UnsupportedOperationException.class)
    public void testRemove_UnsupportedOperationException() {
        new HashMap<>().remove("A");
    }

    @Test (expected = IllegalArgumentException.class)
    public void testContains_ExpectIllegalArgumentException() {
        new HashMap<>().contains(null);
    }

}
