package com.lesson.sweepstakes.service;

import java.util.UUID;


public class HorseRandomGenerator {

    public static String randomUuid() {
        String randomId;
        randomId = UUID.randomUUID().toString();
        return randomId;
    }

    public static int randomAge() {
        int age = Constant.maxAge - Constant.minAge + 1;
        age = (int) (Math.random() * age) + Constant.minAge;
        return age;
    }

    public static int randomSpeed() {

        int randomSpeed = Constant.maxSpeed - Constant.minSpeed + 1;
        randomSpeed = (int) (Math.random() * randomSpeed) + Constant.minSpeed - randomSpeed / randomAge();
        return randomSpeed;
    }

}
