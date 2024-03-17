package com.hackerRank.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class TournamentWinnerChallengeAEService {

    public String tournamentWinner(
            ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results
    ) {
        // Write your code here.
        // Loop results array and store in a map its results, order higher result
        // Return highest

        Map<String,Integer> competitionResults = new HashMap();
        for(int i = 0; i < results.size(); i ++) {
            if(results.get(i) == 1) {
                /*System.out.println("results.get(i) == 1");
                System.out.println("i : " + i);
                System.out.println("Test 1: " + competitions.get(i).get(0));*/
                if(competitionResults.containsKey(competitions.get(i).get(0))) {
                    Integer resultsSoFar = competitionResults.get(competitions.get(i).get(0));
                    competitionResults.put(String.valueOf(competitions.get(i).get(0)), resultsSoFar + 3);
                } else {
                    competitionResults.put(String.valueOf(competitions.get(i).get(0)), 3);
                }
                if(competitionResults.containsKey(competitions.get(i).get(1))) {
                    Integer resultsSoFar = competitionResults.get(competitions.get(i).get(1));
                    competitionResults.put(String.valueOf(competitions.get(i).get(1)), resultsSoFar + 0);
                } else {
                    competitionResults.put(String.valueOf(competitions.get(i).get(1)), 0);
                }
                /*System.out.println("The map: ");
                competitionResults.forEach((key, value) -> System.out.println(key + " " + value));*/
            } else {
                /*System.out.println("results.get(i) == 0");
                System.out.println("i : " + i);
                System.out.println("Test 2: " + competitions.get(i).get(1));*/
                if(competitionResults.containsKey(competitions.get(i).get(1))) {
                    Integer resultsSoFar = competitionResults.get(competitions.get(i).get(1));
                    competitionResults.put(String.valueOf(competitions.get(i).get(1)), resultsSoFar + 3);
                } else {
                    competitionResults.put(String.valueOf(competitions.get(i).get(1)), 3);
                }
                if(competitionResults.containsKey(competitions.get(i).get(0))) {
                    Integer resultsSoFar = competitionResults.get(competitions.get(i).get(0));
                    competitionResults.put(String.valueOf(competitions.get(i).get(0)), resultsSoFar + 0);
                } else {
                    competitionResults.put(String.valueOf(competitions.get(i).get(0)), 0);
                }

                /*System.out.println("The map: ");
                competitionResults.forEach((key, value) -> System.out.println(key + " " + value));*/
            }
        }
        /*System.out.println("Final result");
        System.out.println(Collections.max(competitionResults.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey());*/


        log.info("The competitions array: ");
        competitions.forEach(System.out::println);
        log.info("Results array:");
        results.forEach(System.out::println);
        log.info("Team winner is: " + Collections.max(competitionResults.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey());
        return Collections.max(competitionResults.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
    }
}
