package com.hackerRank.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StringSubsequenceService {

    /**
     * We say that a string contains the word hackerrank if a subsequence of its characters spell the word hackerrank.
     * Remeber that a subsequence maintains the order of characters selected from a sequence.
     *
     * More formally, let p[0], p[1],...,p[9] be the respective indices of h, a, c, k, e, r, r, a, n, k in string s.
     * If s is inside other string with its respective order this is true.
     * If is true, then contains hackerrank.
     *
     * For each query, print YES on a new line if the string contains hackerrank, otherwise, print NO.
     * Example
     * s=haacckkerrannkk
     * This contains a subsequence of all the characters in the proper order. Answer YES
     * s=haacckkerannk
     * This is missing the second 'r'. Answer NO.
     * s=hccaakkerrannkk
     * There is no 'c' after the first occurrence of an 'a', so answer NO.
     *
     *
     * Function Description
     *
     * Complete the hackerrankInString function in the editor below.
     *
     * hackerrankInString has the following parameter(s):
     *
     * string s: a string
     *
     * Returns
     *
     * string: YES or NO
     */

    private final String TEXT_TO_VALIDATE = "hhaacckkekraraannk";
    //private final String TEXT_TO_VALIDATE = "hccaakkerrannkk";
    private final String SUBSEQUENCE_STRING = "hackerrank";

    public void verify() {
        if(TEXT_TO_VALIDATE.length() < SUBSEQUENCE_STRING.length()) {
            throw new IllegalArgumentException("Text to validate needs to be at least the same length than subsecuence string");
        }
        String result = "NO";
        int aux = 0;
        for(int i = 0; i < TEXT_TO_VALIDATE.length(); i ++) {
            if(aux == (SUBSEQUENCE_STRING.length() - 1)){
                result = "YES";
                break;
            }
            if(TEXT_TO_VALIDATE.charAt(i) == SUBSEQUENCE_STRING.charAt(aux)){
                aux += 1;
            }
        }

        log.info("Text to validate  : " + TEXT_TO_VALIDATE);
        log.info("Subsequence string: " + SUBSEQUENCE_STRING);
        log.info("Result: " + result);
    }
}
