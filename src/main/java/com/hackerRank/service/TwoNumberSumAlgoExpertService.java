package com.hackerRank.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class TwoNumberSumAlgoExpertService {

    /**
     *
     * Two Number Sum
     * Write a function that takes a non-empty array of distinct integers and an integer representing a target sum.
     * If any two numbers in the input array sum up to the target sum, the function should return them in an array,
     * in any order.
     * If no two numbers sum up to the target sum, the function should return an empty array.
     *
     * Note that the target sum has to be obtained by summing two different integers in the array; you can't add
     * a single integer to itself in order to obtain the target sum.
     *
     * You can assume that there will be at most one pair of numbers summing up to the target sum.
     *
     * Try this out in AppRunner: algoExpertService.twoNumberSum(new int[] {3, 5, -4, 8, 11, 1, -1, 6}, 10);
     *
     */
    public int[] twoNumberSumWorstSolution(int[] array, int targetSum) {
        log.info("O(n*n)");
        //Validate non empty array
        if(array.length == 0) {
            throw new IllegalArgumentException("Array can not be empty");
        }
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length; j++) {
                log.info("i: " + i);
                log.info("j: " + j);
                log.info("Asking array[i] != array[j]: ");
                log.info(String.valueOf(array[i] != array[j]));
                if(array[i] != array[j]){
                    log.info("array[i] + array[j]) == targetSum");
                    log.info(array[i] + " + " + array[j] + " = " + targetSum);
                    log.info(String.valueOf(array[i] + array[j] == targetSum));
                    if((array[i] + array[j]) == targetSum) {
                        int[] result = new int[]{array[i], array[j]};
                        log.info("Result: ");
                        log.info(Arrays.toString(result));
                        return result;
                    }
                }
            }
        }
        log.info("Returning empty array");
        return new int[0];
    }


    public int[] twoNumberSumOptimalSolution(int[] array, int targetSum) {
        log.info("O(n)");
        //Validate non empty array
        if(array.length == 0) {
            throw new IllegalArgumentException("Array can not be empty");
        }

        Set<Integer> hashSet = new HashSet<>();
        for(int i = 0; i < array.length; i++){
            if(hashSet.contains(targetSum - array[i])){
                log.info("Result: ");
                log.info(targetSum - array[i] + " : " + array[i]);
                return new int[] {targetSum - array[i], array[i]};
            }
            hashSet.add(array[i]);
        }
        log.info("Returning empty array");
        return new int[0];
    }


    public int[] twoNumberSumSolution2(int[] array, int targetSum) {
        log.info("O(n*n), this is a bad solution but a good one if we care about duplicates in the problem");
        //Validate non empty array
        if(array.length == 0) {
            throw new IllegalArgumentException("Array can not be empty");
        }
        Map<Integer, Integer> theMap = new HashMap<>();
        for(int i = 0; i < array.length; i++) {
            theMap.put(i, array[i]);
        }
        /*log.info("The map: ");
        theMap.forEach((k, v) -> System.out.println((k + ":" + v)));*/
        for(int i = 0; i < array.length; i++) {
            if(targetSum - array[i] == array[i]){
                if(theMap.containsValue(targetSum - array[i])) {
                    Map<Integer, Integer> duplicates = getDuplicates(theMap, array[i], i);
                    if(duplicates.size() > 0) {
                        log.info("Result: ");
                        log.info(targetSum - array[i] + " : " + array[i]);
                        return new int[] {targetSum - array[i], array[i]};
                    }
                }
            } else {
                if(theMap.containsValue(targetSum - array[i])) {
                    log.info("Result: ");
                    log.info(targetSum - array[i] + " : " + array[i]);
                    return new int[] {targetSum - array[i], array[i]};
                }
            }
        }
        log.info("Returning empty array");
        return new int[0];
    }

    private Map<Integer, Integer> getDuplicates(Map<Integer, Integer> theMap, Integer number, Integer key) {
        Map<Integer, Integer> returnMap = new HashMap<>();
        theMap.entrySet().stream()
                .filter(i ->  i.getValue() == number && i.getKey() != key)
                .forEach((entry) -> {
                    log.info("Duplicate found: " + entry.getKey() + " -> " + entry.getValue() + " for number: " + number);
                    returnMap.put(entry.getKey(), entry.getValue());
                });
        log.info("Duplicates size: " + returnMap.size() + " for number: " + number);
        return returnMap;
    }
}
