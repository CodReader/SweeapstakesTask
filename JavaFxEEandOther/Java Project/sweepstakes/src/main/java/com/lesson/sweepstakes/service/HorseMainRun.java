package com.lesson.sweepstakes.service;

import com.lesson.sweepstakes.dao.Horse;
import com.lesson.sweepstakes.dao.RaceResult;
import com.lesson.sweepstakes.util.constant.HorseConstant;
import com.lesson.sweepstakes.util.generator.HorseGenerator;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class HorseMainRun {

    private static final Logger logger = Logger.getLogger(HorseMainRun.class.getName());

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(HorseConstant.HORSE_COUNT);

        try {
            List<Future<RaceResult>> results = executorService.invokeAll(races);
            executorService.shutdown();
            for (int i = 0; i < HorseConstant.HORS_SIZE; i++) {
                Future<RaceResult> future = results.get(i);
                try {
                    RaceResult result = future.get();
                    logger.log(Level.INFO, "End run with result: {0}", result);
                } catch (InterruptedException | ExecutionException e) {
                    logger.log(Level.WARNING, "Interrupted | Execution", e);
                    Thread.currentThread().interrupt();
                }
            }
        } catch (InterruptedException e) {
            logger.log(Level.WARNING, "Interrupted!", e);
        }
    }
}