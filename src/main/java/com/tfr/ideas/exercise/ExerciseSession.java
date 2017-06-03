package com.tfr.ideas.exercise;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by Erik on 6/2/2017.
 */
public class ExerciseSession {

    private LocalDate date;
    private List<Exercise> exercises;
    private boolean usedPreworkout;
    private double scoopsPreworkout;

    public ExerciseSession() {
        exercises = new ArrayList<>();
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    public boolean isUsedPreworkout() {
        return usedPreworkout;
    }

    public void setUsedPreworkout(boolean usedPreworkout) {
        this.usedPreworkout = usedPreworkout;
    }

    public double getScoopsPreworkout() {
        return scoopsPreworkout;
    }

    public void setScoopsPreworkout(double scoopsPreworkout) {
        this.scoopsPreworkout = scoopsPreworkout;
    }

    @Override
    public String toString() {
        return "ExerciseSession{" +
                "date=" + date +
                ", exercises=" + exercises +
                ", usedPreworkout=" + usedPreworkout +
                ", scoopsPreworkout=" + scoopsPreworkout +
                '}';
    }
}
