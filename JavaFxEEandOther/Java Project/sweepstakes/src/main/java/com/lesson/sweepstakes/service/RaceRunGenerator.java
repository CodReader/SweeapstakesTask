package com.lesson.sweepstakes.service;

import com.lesson.sweepstakes.dao.Horse;
import com.lesson.sweepstakes.util.constant.RaceConstant;

public class RaceRunGenerator {
    public static int raceRun() {
        int raceTime;
        if (RaceConstant.RACE_LENGTH != 0) {
            raceTime = RaceConstant.RACE_LENGTH / Horse.getModelSpeed() * RaceConstant.WEATHER;
        } else {
            System.out.println("Error");
        }
        return raceTime;
    }

}

