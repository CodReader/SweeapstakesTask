package com.lesson.sweepstakes.service;

import com.lesson.sweepstakes.dao.Horse;
import com.lesson.sweepstakes.util.constant.HorseConstant;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class HorseMainRun {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(HorseConstant.HORSE_COUNT);
        List<Future<Horse>> resultList = null;
        List<Race> raceList = new ArrayList<>();
        for (int i = 0; i < HorseConstant.HORS_SIZE; i++) {
            Race race = new Race();
            raceList.add(race);
        }

        try {
            resultList = executorService.invokeAll(raceList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdown();

        for (int i = 0; i < resultList.size(); i++) {
            Future<Horse> future = resultList.get(i);
            try {
                Horse horse = future.get();
                System.out.println("Horse Id:"+horse.getId()+"\n"+"Horse speed:"+horse.getModelSpeed()+"\n"+"Horse race time:"+RaceRunGenerator.raceRun());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}

