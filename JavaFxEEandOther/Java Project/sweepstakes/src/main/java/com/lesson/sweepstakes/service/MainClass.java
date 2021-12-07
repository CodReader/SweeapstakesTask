package com.lesson.sweepstakes.service;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
/*public class MainClass {
    public static void main(String[] args) {
        for (int i = 0 ; i<=7;i++){
            Horse horse = new Horse();
            System.out.println();
        }

    }
}*/

public class MainClass {
    public static void main(String[] args) {
        Horse horse = new Horse();

        List<Horse> horseList = Arrays.asList(new Horse(horse.randomID(), horse.randomSpeed()), new Horse(horse.randomID(), horse.randomSpeed()), new Horse(horse.randomID(), horse.randomSpeed()), new Horse(horse.randomID(), horse.randomSpeed()), new Horse(horse.randomID(), horse.randomSpeed()), new Horse(horse.randomID(), horse.randomSpeed())
                , new Horse(horse.randomID(), horse.randomSpeed()), new Horse(horse.randomID(), horse.randomSpeed()));

        List<Horse> sortedList = horseList.stream().sorted(Comparator.comparingInt(Horse::getSpeed)).collect(Collectors.toList());

        sortedList.forEach(System.out::println);

        sortedList.get(horseList.size() - 1);


    }
}
   /* Horse horse1 = new Horse();
        horse1.randomID();
                horse1.randomAge();
                horse1.randomSpeed();

                Horse horse2 = new Horse();
                horse2.randomID();
                horse2.randomAge();
                horse2.randomSpeed();

                Horse horse3 = new Horse();
                horse3.randomID();
                horse3.randomAge();
                horse3.randomSpeed();

                Horse horse4 = new Horse();
                horse4.randomID();
                horse4.randomAge();
                horse4.randomSpeed();

                Horse horse5 = new Horse();
                horse5.randomID();
                horse5.randomAge();
                horse5.randomSpeed();

                Horse horse6 = new Horse();
                horse6.randomID();
                horse6.randomAge();
                horse6.randomSpeed();

                Horse horse7 = new Horse();
                horse7.randomID();
                horse7.randomAge();
                horse7.randomSpeed();

                Horse horse8 = new Horse();
                horse8.randomID();
                horse8.randomAge();
                horse8.randomSpeed();*/