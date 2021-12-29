
package com.lesson.sweepstakes.dao;


import com.lesson.sweepstakes.service.HorseRandomGenerator;
import com.lesson.sweepstakes.service.HorseResult;


public class Horse extends HorseResult {

    private final int modelSpeed;
    private final String id;


    public Horse(int speed) {
        this.modelSpeed = speed;
        this.id = HorseRandomGenerator.randomUuid();
    }

    public String getId() {
        return id;
    }

    public int getModelSpeed() {
        return modelSpeed;
    }


}