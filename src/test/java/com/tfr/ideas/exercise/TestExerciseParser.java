package com.tfr.ideas.exercise;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;

/**
 *
 * Created by Erik on 6/2/2017.
 */
public class TestExerciseParser {

    @Test
    public void test() throws IOException {
        String data = getTestString("ideas/exercise/exercise_June_2_2017.txt");
        ExerciseSession session = ExerciseParser.parseSession(data);
        System.out.println("-----------------------");
        System.out.println(new ObjectMapper().writeValueAsString(session));
    }

    private String getTestString(String resourceName) throws IOException {
        URL url = Resources.getResource(resourceName);
        String data = Resources.toString(url, Charsets.UTF_8);
        System.out.println(data);
        return data;
    }

}
