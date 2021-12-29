package com.lesson.sweepstakes.service;


import com.lesson.sweepstakes.dao.Horse;

public class RaceRunGenerator {
    Horse horse = new Horse(HorseRandomGenerator.randomSpeed());
    private final int randomSpeed = horse.getModelSpeed();
    private final String horseRandomId = horse.getId();

    public int raceRun() {

        int raceTime;
        if (Constant.raceLength != 0) {
            raceTime = Constant.raceLength / randomSpeed * Constant.weather;
        } else {
            System.out.println("Error");
        }
        return raceTime;
    }

    public String getId() {
        return horseRandomId;
    }
}

