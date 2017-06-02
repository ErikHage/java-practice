package com.tfr.collections.list;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * Created by Erik on 5/30/2017.
 */
public class TestArrayBasedList {

    @Test
    public void test() {
        List<String> list = new ArrayBasedList<>(7);

        assertEquals(0, list.getSize());

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");

        //add(T)
        assertEquals(6, list.getSize());
        System.out.println(list.toString());

        //set(int, T)
        //get(int)
        list.set(0, "0");
        assertEquals("0", list.get(0));
        System.out.println(list.toString());

        //add(int, T)
        list.add(1, "1");
        assertEquals("1", list.get(1));
        assertEquals(7, list.getSize());
        System.out.println(list.toString());

        //indexOf(T)
        assertEquals(1, list.indexOf("1"));

        //remove(int)
        String s = list.remove(1);
        assertEquals("1", s);
        assertEquals(6, list.getSize());
        System.out.println(list.toString());

        //enlarge()
        list.add("G");
        list.add("H");
        assertEquals(8, list.getSize());
        System.out.println(list.toString());
    }

}
