package com.hackerRank.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class CountStringOccurrences {

    /**
     * There is a collection of input strings and a collection of query strings. For each query string determine
     * how many times it occurs in the list of input strings.
     * Return
     * An array with the results according its place in the query collection.
     *
     * Example
     * strings = ['ab', 'ab', 'abc']
     * queries = ['ab', 'abc', 'bc']
     *
     * There are 2 instances of 'ab', 1 of 'abc' and 0 of 'bc'.
     *
     * Result
     * [2, 1, 0]
     *
     * Function description
     * Complete the function matchingStrings; must return an array of integers representing the occurrences of each
     * string in 'strings.
     *
     * Parameters
     * String strings[0,...,n] - an array of strings to search
     * String queries[0,...,q] - an array of query strings
     *
     * Return
     * Integer results[0,...,n] - an array of results for each query
     */
    private final String[] strings = {"ab", "ab", "abc"};
    private final String[] queries = {"ab", "abc", "bc"};

    public void matchingStringsWorstSolution() {
        //Create array results
        Integer[] results = new Integer[queries.length];
        //Double loop to strings and queries to verify occurrences
        //Big(O) Notation nxm, the worst scenario possible.
        for(int i = 0; i < queries.length; i ++) {
            int occurrences = 0;
            for(int j = 0; j < strings.length; j ++) {
                if(strings[j].equals(queries[i])) {
                    occurrences += 1;
                }
            }
            results[i] = occurrences;
        }
        //Return results
        log.info("Strings array: " + Arrays.toString(strings));
        log.info("Queries array: " + Arrays.toString(queries));
        log.info("Results:       " + Arrays.toString(results));
    }

    public void matchingStringsBestSolution() {
        //Create array results
        Integer[] results = new Integer[queries.length];
        Map<String, Integer> occurrences = new HashMap<>();
        //Big(O) Notation n + m. Linear and best solution.
        //Loop strings and fill up a Map, Key will be the string and value will be # of occurrences
        for(int i = 0; i< strings.length; i ++) {
            if(occurrences.containsKey(strings[i])) {
                /*int aux = occurrences.get(strings[i]);
                occurrences.replace(strings[i], aux + 1);*/
                occurrences.put(strings[i], occurrences.get(strings[i]) + 1);
            }
            else {
                occurrences.put(strings[i], 1);
            }
        }
        //Check how many times a word occurs in strings array
        for(int i = 0; i < queries.length; i ++) {
            if(occurrences.containsKey(queries[i])) {
                results[i] = occurrences.get(queries[i]);            }
            else {
                results[i] = 0;
            }
        }
        //Return results
        log.info("Strings array: " + Arrays.toString(strings));
        log.info("Queries array: " + Arrays.toString(queries));
        log.info("Results:       " + Arrays.toString(results));
    }
}
