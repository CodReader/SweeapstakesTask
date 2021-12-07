
package com.lesson.sweepstakes.service;

import java.util.UUID;

public class Horse {

    private int age;
    private int speed;
    private String uniqueID;

    Horse() {
        uniqueID = randomID();
        int age = randomAge();
        int speed = randomSpeed();
    }

    public Horse(String uniqueID, int speed) {
        super();
        this.speed = speed;
        this.uniqueID = uniqueID;
    }

    int randomAge() {
        int min, max;
        max = 30;
        min = 8;
        age = max - min + 1;
        age = (int) (Math.random() * age) + min;
        return age;
    }

    int randomSpeed() {
        Road road = new Road();
        int passability = road.randomPassability();
        int length = road.randomLength();
        int min, max;
        max = 70;
        min = 40;
        speed = max - min + 1;
        speed = (int) (Math.random() * speed) + min - age % length % passability;
        return speed;
    }

    String randomID() {
        uniqueID = UUID.randomUUID().toString();
        return uniqueID;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return this.uniqueID + "\n Horse speed:" + this.speed;
    }


}










