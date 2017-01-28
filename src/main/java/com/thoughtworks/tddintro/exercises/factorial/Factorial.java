package com.thoughtworks.tddintro.exercises.factorial;

public class Factorial {
    public Integer compute(int i) {
        // Test case #5
        if (i < 0){
            throw new IllegalArgumentException();
        }
        // Test case #1, 3
        if (i == 0 || i == 1){
            return 1;
        }
        // Test case #2, 4
        return i * compute(i - 1);
    }
}
