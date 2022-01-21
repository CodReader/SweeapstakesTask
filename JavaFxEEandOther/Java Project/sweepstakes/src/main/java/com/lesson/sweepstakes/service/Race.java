package com.lesson.sweepstakes.service;

import com.lesson.sweepstakes.dao.Horse;
import com.lesson.sweepstakes.util.constant.HorseConstant;
import lombok.Getter;

import java.util.List;
import java.util.concurrent.Callable;
@Getter
public class Race implements Callable<Horse> {

    public  static List<Horse>horsesParam(){
        return HorseGenerator.generateHorses(HorseConstant.HORS_SIZE);
    }

    @Override
    public Horse call() {
        return new Horse(HorseGenerator.generateHorse().getModelSpeed());
    }
}
