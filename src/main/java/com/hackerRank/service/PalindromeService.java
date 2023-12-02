package com.hackerRank.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PalindromeService {

    private final String textToValidate = "anita lava la tina";

    public void verifyPalindrome() {
        log.info("This challenge verify if a text is palindrome \n\ntextToValidate: " + textToValidate);
        if(textToValidate == null || textToValidate.isEmpty()) {
            throw new IllegalArgumentException("The text cannot be null or empty to validate if it is a palindrome.");
        }
        if (textToValidate.matches("^[a-zA-Z]+$"))
            throw new IllegalArgumentException("Numbers or special characters not allowed.");


        String text = textToValidate.trim().replaceAll("\\s+", "").toLowerCase();
        log.info("Text without spaces: " + text);

        boolean isPalindrome = true;
        for(int i = 0; i < text.length() / 2; i++) {
            if(text.charAt(i) != text.charAt((text.length() - 1) - i)) {
                isPalindrome = false;
                break;
            }
        }

        if(isPalindrome)
            System.out.println("The word " + textToValidate + " is a palindrome!!!");
        else
            System.out.println("The word " + textToValidate + " is NOT a palindrome!!!");

    }
}
