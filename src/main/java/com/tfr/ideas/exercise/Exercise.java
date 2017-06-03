package com.tfr.ideas.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by Erik on 6/2/2017.
 */
public class Exercise {

    private String exerciseName;
    private List<ExerciseSet> exerciseSets;

    public Exercise() {
        exerciseSets = new ArrayList<>();
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public List<ExerciseSet> getExerciseSets() {
        return exerciseSets;
    }

    public void setExerciseSets(List<ExerciseSet> exerciseSets) {
        this.exerciseSets = exerciseSets;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "exerciseName='" + exerciseName + '\'' +
                ", exerciseSets=" + exerciseSets +
                '}';
    }
}
