package com.lesson.sweepstakes.service;

import com.lesson.sweepstakes.dao.Horse;
import com.lesson.sweepstakes.dao.RaceResult;
import com.lesson.sweepstakes.util.constant.RaceConstant;
import lombok.Data;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

@Data
public class Race implements Callable<RaceResult> {

    private static final Logger logger = Logger.getLogger(Race.class.getName());

    private Horse horse;

    public Race(Horse horse) {
        this.horse = horse;
    }

    @Override
    public RaceResult call() {
        logger.log(Level.INFO, "Horse start running:{0}", this.horse);
        try {
            long duration = (long) (Math.random() * 10);
            TimeUnit.SECONDS.sleep(duration);
        } catch (Exception e) {
            logger.log(Level.WARNING, "Horses broke down in race", e);
            Thread.currentThread().interrupt();
        }
        return new RaceResult(horse, calculateRaceTime(horse.getModelSpeed()));
    }

    public static int calculateRaceTime(int horseSpeed) {
        return RaceConstant.RACE_LENGTH / horseSpeed * RaceConstant.WEATHER;
    }
}
