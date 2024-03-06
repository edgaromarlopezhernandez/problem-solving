package com.hackerRank.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class IsValidSubsequenceAlgoExpertService {
    /**
     *
     * Validate Subsequence✩
     * Given two non-empty arrays of integers, write a function that determines whether the second array is a
     * subsequence of the first one.
     * A subsequence of an array is a set of numbers that aren't necessarily adjacent in the array but that are in
     * the same order as they appear in the array.
     * For instance, the numbers [1, 3, 4] form a subsequence of the array [1, 2, 3, 4], and so do the numbers [2, 4].
     * Note that a single number in an array and the array itself are both valid subsequences of the array.
     *
     * Sample Input
     * array = [5, 1, 22, 25, 6, -1, 8, 10]
     * sequence = [1, 6, -1, 10]
     *
     * Sample Output
     * true
     */
    public boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        // Write your code here.
        boolean result = false;
        int sequenceIndex = 0;
        for(int index = 0; index < sequence.size(); index ++){
            while(sequenceIndex < array.size()) {
                if(sequence.get(index) == array.get(sequenceIndex)) {
                    result = true;
                    break;
                } else {
                    result = false;
                }
                sequenceIndex += 1;
            }
        }
        log.info("Array:" + array);
        log.info("Sequence:" + sequence);
        log.info("Is valid subsequence?");
        log.info(String.valueOf(result));
        return result;
    }

    public boolean isValidSubsequenceWithSubsequenceDuplicates(List<Integer> array, List<Integer> sequence) {
        // Write your code here.
        boolean result = false;
        int index = 0;
        int sequenceIndex = 0;
        int lastSequenceElement = -3000;
        while(index < sequence.size()){
            while(sequenceIndex < array.size()) {
                if(sequence.get(index) == lastSequenceElement && (index + 1) < sequence.size()) {
                    index += 1;
                }
                if(sequence.get(index) == array.get(sequenceIndex)) {
                    result = true;
                    break;
                } else {
                    result = false;
                }
                sequenceIndex += 1;
            }
            index += 1;
        }
        log.info("Array:" + array);
        log.info("Sequence:" + sequence);
        log.info("Is valid subsequence?");
        log.info(String.valueOf(result));
        return result;
    }
}
