package com.hackerRank.utils;

import com.hackerRank.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class AppRunner implements CommandLineRunner {
    @Autowired
    private PalindromeService palindromeService;
    @Autowired
    private MarsExplorationService marsExplorationService;
    @Autowired
    private StringSubsequenceService stringSubsequenceService;
    @Autowired
    private CountStringOccurrences countStringOccurrences;
    @Autowired
    private PangramsService pangramsService;
    @Autowired
    private ElectronicsShopService electronicsShopService;
    @Autowired
    private CatsAndAMouseService catsAndAMouseService;
    @Autowired
    private TwoNumberSumAlgoExpertService twoNumberSumAlgoExpertService;
    @Autowired
    private IsValidSubsequenceAlgoExpertService isValidSubsequenceAlgoExpertService;
    @Autowired
    private VisaCompanyChallengeService visaCompanyChallengeService;
    /*@Autowired
    private EighthQueensChallengeService eighthQueensChallengeService;*/
    @Autowired
    private TournamentWinnerChallengeAEService tournamentWinnerChallengeAEService;

    @Override
    public void run(String... args) throws Exception {
        log.info("App started...");

        //palindromeService.verifyPalindrome();
        //marsExplorationService.verifySignalReceivedByEarth();
        //stringSubsequenceService.verify();
        //countStringOccurrences.matchingStringsFirstSolution();
        //countStringOccurrences.matchingStringsBestSolution();
        //pangramsService.isPangram();
        //electronicsShopService.getMoneySpent();
        //catsAndAMouseService.catAndMouse();
        //algoExpertService.twoNumberSumWorstSolution(new int[] {3, 5, -4, 8, 11, 1, -1, 6}, 10);
        //algoExpertService.twoNumberSumOptimalSolution(new int[] {3, 5, -4, 8, 11, 1, -1, 6}, 10);
        //algoExpertService.twoNumberSumSolution2(new int[] {5, 3, -1, -4, 8, 11, 1, -1, 6, 3, -1, 5 }, 10);
        //algoExpertService.twoNumberSumSolution2(new int[] {3, 5, -4, 8, 11, 1, -1, 6}, 10);
        /*List<String> myList = Arrays.asList("HolA", "EdgaR", "Omar", "Lopez", "Hernandez", "Mariel", "Bonifacio", "Arellano");
        System.out.println("**********************************");
        System.out.println(myList);
        List<String> newList = myList.stream()
                .filter(value -> value.contains("a"))
                .map(x -> x.substring(0, 1).toUpperCase() + x.substring(1).toLowerCase())
                .collect(Collectors.toList());
        System.out.println(newList);*/
       /* List<Integer> array = new ArrayList<>();
        array.add(5);
        array.add(1);
        array.add(22);
        array.add(25);
        array.add(6);
        array.add(-1);
        array.add(8);
        array.add(10);
        List<Integer> sequence = new ArrayList<>();
        sequence.add(1);
        sequence.add(6);
        sequence.add(-1);
        sequence.add(10);*/
       /* List<Integer> array = new ArrayList<>();
        array.add(5);
        array.add(1);
        array.add(22);
        array.add(25);
        array.add(6);
        array.add(-1);
        array.add(8);
        array.add(10);
        List<Integer> sequence = new ArrayList<>();
        sequence.add(5);
        sequence.add(1);
        sequence.add(22);
        sequence.add(22);
        sequence.add(25);
        sequence.add(6);
        sequence.add(-1);
        sequence.add(8);
        sequence.add(10);
        System.out.println("****************************");
        isValidSubsequenceAlgoExpertService.isValidSubsequenceWithSubsequenceDuplicates(array, sequence);*/


        //visaCompanyChallengeService.operationSuffix("4 2 *");
        //visaCompanyChallengeService.operationSuffix("5 10 55 25 + * -");


        //eighthQueensChallengeService.eightQueens(new String[] {"(1,3)", "(2,8)", "(3,4)", "(4,7)", "(5,1)", "(6,6)", "(7,2)", "(8,5)"});


        ArrayList<ArrayList<String>> competitions = new ArrayList<>();
        competitions.add(0, new ArrayList<>(
                List.of("HTML",
                        "C#")
        ) );
        competitions.add(1, new ArrayList<>(
                List.of("C#",
                        "Python")
        ) );
        competitions.add(2, new ArrayList<>(
                List.of("Python",
                        "HTML")
        ) );

        ArrayList<Integer> results = new ArrayList<>(
                List.of(0,
                        0,
                        1)
        );
        tournamentWinnerChallengeAEService.tournamentWinner(competitions, results);

    }
}