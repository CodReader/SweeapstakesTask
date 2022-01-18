package com.lesson.sweepstakes.service;

import com.lesson.sweepstakes.dao.Horse;
import com.lesson.sweepstakes.util.constant.HorseConstant;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HorseGenerator {

    private static final Random random = new Random();

    private HorseGenerator() {}

    public static List<Horse> generateHorses(int horseSize) {
        List<Horse> horses = new ArrayList<>(horseSize);
        for (int i = 0; i < horseSize; i++) {
            horses.add(generateHorse());
        }
        return horses;
    }

    private static Horse generateHorse() {
        return new Horse(randomSpeed());
    }

    private static int randomAge() {
        return random.nextInt(HorseConstant.MAX_AGE - HorseConstant.MIN_AGE) + HorseConstant.MIN_AGE;
    }

    private static int randomSpeed() {
        return random.nextInt(HorseConstant.MAX_SPEED - HorseConstant.MIN_SPEED) + HorseConstant.MIN_SPEED % randomAge();
    }
}


