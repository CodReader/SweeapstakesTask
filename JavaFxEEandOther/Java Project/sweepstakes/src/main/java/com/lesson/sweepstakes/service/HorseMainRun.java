package com.lesson.sweepstakes.service;


import com.lesson.sweepstakes.dao.Horse;
import lombok.SneakyThrows;


import java.util.*;
import java.util.concurrent.*;

public class HorseMainRun {
    @SneakyThrows
    public static void main(String[] args) {
        int horseCount = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(horseCount);
        Comparator<Horse> full = new HorseIDComparator().thenComparing(new HorseSpeedComparator());
        TreeSet<Horse> horses = new TreeSet<>(full);
        for (int i = 0; i < 8; i++) {
            horses.add(new Horse(HorseRandomGenerator.randomSpeed()));
        }
        Thread.sleep(2000);
        List<Future<Object>> sub = executorService.invokeAll(horses);


        for (Future<Object> f : sub) {
            System.out.println(f.get());
        }

        System.out.println("FINISHED");
        executorService.shutdown();
    }


    public static class HorseIDComparator implements Comparator<Horse> {
        public int compare(Horse a, Horse b) {
            return a.getId().compareTo(b.getId());
        }
    }

    public static class HorseSpeedComparator implements Comparator<Horse> {
        public int compare(Horse a, Horse b) {
            return Integer.compare(a.getModelSpeed(), b.getModelSpeed());
        }
    }

}
