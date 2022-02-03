package com.lesson.sweepstakes.dao;

import lombok.Data;

@Data
public class RaceResult {

    private int raceTime;

    private Horse horse;

    public RaceResult(Horse horse, int raceTime) {
        this.raceTime = raceTime;
        this.horse = horse;
    }
}

