package com.hackerRank.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class VisaCompanyChallengeService {

    /**
     * Operation suffix
     *
     * Given a valid input like the ones below, write a method that performs the correct operations.
     *
     * 4 2 *
     * 5 10 55 + *
     *
     * Results
     * 8
     * 825
     */

    public Double operationSuffix(String validInput) {
        // 1 Assume it is a valid input, so let's split it by empty blank space
        String[] parts = validInput.split(" ");

        // 2 Find out how many operations needs to be done
        int numberOfOperators = 0;
        int indexToCountOperators = parts.length - 1;
        while(parts[indexToCountOperators].equalsIgnoreCase("/")
                || parts[indexToCountOperators].equalsIgnoreCase("*")
                || parts[indexToCountOperators].equalsIgnoreCase("+")
                || parts[indexToCountOperators].equalsIgnoreCase("-")) {
            numberOfOperators +=1;
            indexToCountOperators -=1;
        }

        // 3 Loop through the array from where operators start and then chain operations
        int operatorIndex = parts.length - numberOfOperators;
        int index = 0;
        Double result = 0D;
        while(operatorIndex < parts.length) {
            Double firstValue;
            Double secondValue;
            if(index == 0) {
                firstValue = Double.parseDouble(parts[index]);
                index += 1;
                secondValue = Double.parseDouble(parts[index]);
                index += 1;

            } else {
                firstValue = result;
                secondValue = Double.parseDouble(parts[index]);
                index += 1;
            }
            switch (parts[operatorIndex]){
                case "/": result = firstValue / secondValue;
                    System.out.println("=> " + firstValue + " " + "/ " + secondValue + " = " + result);
                    break;
                case "*": result = firstValue * secondValue;
                    System.out.println("=> " + firstValue + " " + "* " + secondValue + " = " + result);
                    break;
                case "+": result = firstValue + secondValue;
                    System.out.println("=> " + firstValue + " " + "+ " + secondValue + " = " + result);
                    break;
                case "-": result = firstValue - secondValue;
                    System.out.println("=> " + firstValue + " " + "- " + secondValue + " = " + result);
                    break;
                default:
                    System.out.println("operator not allowed: " + parts[operatorIndex]);
                    break;
            }
            operatorIndex += 1;
        }
        log.info("Result for input: " + validInput);
        log.info(String.valueOf(result));

        // 4 Return the result
        return result;
    }


    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
