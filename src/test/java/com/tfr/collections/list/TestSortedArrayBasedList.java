package com.tfr.collections.list;

import com.tfr.collections.support.person.Person;
import com.tfr.collections.support.person.PersonBirthYearComparator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 *
 * Created by Erik on 6/2/2017.
 */
public class TestSortedArrayBasedList {

    private Person p1 = new Person("Erik","Hage",1986);
    private Person p2 = new Person("John","Smith",1950);
    private Person p3 = new Person("Sarah","Conner",1998);
    private Person p4 = new Person("Wally","West",2001);
    private Person p5 = new Person("Tom","Brady",1969);

    @Test
    public void test_usingNaturalOrdering() {
        List<Person> list = new SortedArrayBasedList<>();

        assertEquals(0, list.getSize());

        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);

        assertEquals(p5, list.get(0));
        assertEquals(p3, list.get(1));
        assertEquals(p1, list.get(2));
        assertEquals(p2, list.get(3));
        assertEquals(p4, list.get(4));
    }

    @Test
    public void test_usingBirthYearComparator() {
        List<Person> list = new SortedArrayBasedList<>(new PersonBirthYearComparator(), 4);

        assertEquals(0, list.getSize());

        list.add(p1);
        list.add(p2);
        list.add(p3);

        //add(T)
        //get(int)
        assertEquals(3, list.getSize());
        assertEquals(p2, list.get(0));

        //enlarge()
        list.add(p4);
        list.add(p5);
        assertEquals(5, list.getSize());

        //remove(T)
        assertTrue(list.remove(p2));
        assertEquals(4, list.getSize());

        //indexOf(T)
        assertEquals(3, list.indexOf(p4));

        //remove(int)
        Person p = list.remove(3);
        assertEquals(p4, p);
        assertEquals(3, list.getSize());
    }

}
