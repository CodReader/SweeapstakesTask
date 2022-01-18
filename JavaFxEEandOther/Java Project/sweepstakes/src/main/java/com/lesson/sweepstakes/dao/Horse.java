package com.lesson.sweepstakes.dao;

import lombok.Data;

import java.util.UUID;

@Data
public class Horse {

    private UUID id = UUID.randomUUID();

    private int modelSpeed;

    public Horse(int speed) {
        this.modelSpeed = speed;
    }
}