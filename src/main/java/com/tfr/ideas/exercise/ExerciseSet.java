package com.tfr.ideas.exercise;

/**
 *
 * Created by Erik on 6/2/2017.
 */
public class ExerciseSet {

    protected double weight;
    protected double reps;

    public ExerciseSet() {

    }

    public ExerciseSet(int weight, int reps) {
        this.weight = weight;
        this.reps = reps;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getReps() {
        return reps;
    }

    public void setReps(double reps) {
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
