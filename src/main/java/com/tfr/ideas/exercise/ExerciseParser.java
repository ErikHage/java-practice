package com.tfr.ideas.exercise;

import com.google.common.collect.Lists;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * Created by Erik on 6/2/2017.
 */
public class ExerciseParser {

    public static ExerciseSession parseSession(String exerciseLog) {
        ExerciseSession session = new ExerciseSession();

        List<String> lines = Lists.newArrayList(exerciseLog.split("\n"));

        String header = lines.remove(0);

        String dateString;
        if(header.contains(":")) {
            session.setUsedPreworkout(true);
            String[] headerSplit = header.split(":");
            dateString = headerSplit[0];
            double preWorkout = Double.parseDouble(headerSplit[1]);
            session.setScoopsPreworkout(preWorkout);
        } else {
            dateString = header;
        }
        session.setDate(stringToDate(dateString));

        for(String line: lines) {
            Exercise exercise = new Exercise();

            List<String> parts = Arrays.asList(line.split(":"));
            String exerciseName = parts.get(0);
            String exerciseDetails = parts.get(1);

            exercise.setExerciseName(exerciseName);
            exercise.setExerciseSets(parseExerciseSets(exerciseDetails));

            session.getExercises().add(exercise);
        }

        return session;
    }

    private static List<ExerciseSet> parseExerciseSets(String sets) {
        List<ExerciseSet> setList = new ArrayList<>();

        sets = sets.trim();
        String[] weightSets = sets.split(" ");

        for(String weightSet: weightSets) {
            int weight = 0;
            if(weightSet.contains(";")) {
                String[] parts = weightSet.split(";");
                weight = Integer.parseInt(parts[0]);
                weightSet = parts[1];
            }
            String[] reps = weightSet.split(",");
            for(String rep : reps) {
                setList.add(new ExerciseSet(weight, Integer.parseInt(rep)));
            }
        }

        return setList;
    }


    private static LocalDate stringToDate(String headerDate) {
        String[] dateParts = headerDate.split("/");
        LocalDate date = LocalDate.of(
                Integer.parseInt(dateParts[2]),
                Integer.parseInt(dateParts[0]),
                Integer.parseInt(dateParts[1])
        );
        return date;
    }

}
