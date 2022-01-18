package com.lesson.sweepstakes.service;

import com.lesson.sweepstakes.util.constant.HorseConstant;
import lombok.SneakyThrows;

import java.util.*;
import java.util.concurrent.*;

public class HorseMainRun {
    @SneakyThrows
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(HorseConstant.HORSE_COUNT);
        List<Future<Object>> sub = executorService.invokeAll();
        for (Future<Object> f : sub) {
            System.out.println("Hors param is:" + f.get());
        }
        System.out.println("FINISHED");
        executorService.shutdown();
    }
}

