package com.lesson.sweepstakes.service;


import java.util.ArrayList;

import java.util.List;
import java.util.concurrent.Callable;

public class HorseResult implements Callable<Object> {

    @Override
    public Object call() throws Exception {
        Thread.sleep(500);
        List<Object> raceRun = new ArrayList<>();
        RaceRunGenerator race = new RaceRunGenerator();
        raceRun.add(race.getId());
        raceRun.add(race.raceRun());
        return raceRun;
    }
}
