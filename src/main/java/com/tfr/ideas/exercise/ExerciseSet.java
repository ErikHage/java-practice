package com.tfr.ideas.exercise;

/**
 *
 * Created by Erik on 6/2/2017.
 */
public class ExerciseSet {

    private int weight;
    private int reps;

    public ExerciseSet() {

    }

    public ExerciseSet(int weight, int reps) {
        this.weight = weight;
        this.reps = reps;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    @Override
    public String toString() {
        return "ExerciseSet{" +
                "weight=" + weight +
                ", reps=" + reps +
                '}';
    }
}
