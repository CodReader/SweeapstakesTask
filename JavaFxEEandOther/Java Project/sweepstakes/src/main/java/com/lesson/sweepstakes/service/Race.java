package com.lesson.sweepstakes.service;

import com.lesson.sweepstakes.dao.Horse;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class Race implements Callable<List<Object>>  {

    public static List<Horse> param() {return HorseGenerator.generateHorses(8);}

    public  List<Object> call() throws Exception {
        List<Object> horses = new ArrayList<>();
        horses.add(RaceRunGenerator.raceRun(),param());
        Thread.sleep(1000);
        return horses;
    }
}
