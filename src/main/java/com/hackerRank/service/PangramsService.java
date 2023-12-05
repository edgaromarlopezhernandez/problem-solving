package com.hackerRank.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class PangramsService {
    /**
     * A pangram is a string that contains every letter of the alphabet. Given a sentence determine whether it is
     * a pangram in the English alphabet. Ignore case. Return either pangram or not pangram as appropriate.
     *
     * Example
     * s="The quick brown fox jumps over the lazy dog"
     * The string contains all letters in the English alphabet, so return pangram.
     *
     * Function Description
     *
     * Complete the function pangrams in the editor below. It should return the string pangram if the input string is
     * a pangram. Otherwise, it should return not pangram.
     *
     * Pangrams have the following parameter(s):
     *
     *     string s: a string to test
     *
     * Returns
     *
     *     string: either pangram or not pangram
     *
     * Input Format
     *
     * A single line with string s
     *
     * Constraints
     *
     * 0 < length of s <= 10 at 3
     *
     * Each character of s, s[i] E {a-z,A-Z, space}.
     *
     * Example 0
     *
     * We promptly judged antique ivory buckles for the next prize
     *
     * Result
     *
     * Pangram
     *
     * Sample Explanation 0
     *
     * All of the letters of the alphabet are present in the string.
     *
     * Sample Input 1
     *
     * We promptly judged antique ivory buckles for the prize
     *
     * Sample Output 1
     *
     * not pangram
     *
     * Sample Explanation 0
     *
     * The string lacks an x.
     */

    private final String textToValidate= "The quick brown fox jumps over the lazy dog";
    //private final String textToValidate= "We promptly judged antique ivory buckles for the prize";

    public void isPangram() {
        //Validate length and constraints
        if(textToValidate.length() > 1000)
            throw new IllegalArgumentException("String must be smaller than 1000 characters");
        //lower case textToValidate
        String lowerCaseString = textToValidate.trim().toLowerCase();
        if (lowerCaseString.matches("^[a-zA-Z ]+$")) {
            log.info("Text to validate: " + textToValidate);
            log.info("The string contains only letters and spaces. It's a valid string");
        } else {
            log.info("The string contains numbers or special characters.");
            throw new IllegalArgumentException("String to validate can not contain numbers or special characters");
        }
        //Create Map and initialize it with all the letters in the alphabet and each value as 0
        Map<String, Integer> alphabet = new HashMap<>();
        for (char ch = 'a'; ch <= 'z'; ++ch)
            alphabet.put(String.valueOf(ch), 0);

        //For loop to map all its chars
        for(int i = 0; i < lowerCaseString.length(); i++) {
            String letterToSearch = String.valueOf(lowerCaseString.charAt(i));
            if(alphabet.containsKey(letterToSearch)) {
                if(alphabet.get(letterToSearch) == 0) {
                    alphabet.put(letterToSearch, 1);
                }
            }
        }

        //Check Map and return result
        String result = "Pangram";
        for(Integer value: alphabet.values()) {
            if(value == 0) {
                result = "Not pangram";
                break;
            }
        }

        log.info(result);
    }
}
