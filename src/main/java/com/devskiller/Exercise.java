package com.devskiller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Exercise {

    public List<Integer> findDuplicates(List<Integer> integers, int numberOfDuplicates) {
        if(numberOfDuplicates < 2) {
            throw new IllegalArgumentException("Duplicate can be only found for two or more elements");
        }
        Map<Integer, Integer>  numOfCur = new HashMap<>();
        for (Integer integer : integers) {
            if(integer == null) { continue;}
            Integer occurences = numOfCur.getOrDefault(integer, 0);
            numOfCur.put(integer, occurences + 1);
        }
        return numOfCur.entrySet().stream().filter(entry -> entry.getValue() == numberOfDuplicates).map(Map.Entry::getKey).collect(Collectors.toList());
    }

}
