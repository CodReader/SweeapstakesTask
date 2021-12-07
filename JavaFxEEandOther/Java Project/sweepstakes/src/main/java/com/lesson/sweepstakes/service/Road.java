package com.lesson.sweepstakes.service;

public class Road {
    private int length;
    private int passability;

    Road() {
        length = randomLength();
        passability = randomPassability();
    }

    public Road(int length, int passability) {
        this.length = length;
        this.passability = passability;
    }

    int randomLength() {
        int min, max;
        max = 2000;
        min = 1000;
        length = max - min + 1;
        length = (int) (Math.random() * length) + min;
        return length;
    }

    int randomPassability() {
        int min, max;
        max = 4;
        min = 1;
        passability = max - min + 1;
        passability = (int) (Math.random() * length) + min;
        return passability;
    }
}
