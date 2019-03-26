package com.ehage;

import org.w3c.dom.Document;

import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Erik on 11/6/2016.
 */
public abstract class AbstractRule {

    private List<Predicate<Document>> predicates;

    public String run(Document document) {
        String output;
        predicates.forEach(p -> {

        });



        return output;
    }

}
