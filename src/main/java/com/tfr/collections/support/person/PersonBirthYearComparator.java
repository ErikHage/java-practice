package com.tfr.collections.support.person;

import java.util.Comparator;

/**
 *
 * Created by Erik on 6/2/2017.
 */
public class PersonBirthYearComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getBirthYear() - o2.getBirthYear();
    }
}
