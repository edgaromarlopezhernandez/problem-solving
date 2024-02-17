package com.hackerRank.utils;

import com.hackerRank.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
    private AlgoExpertService algoExpertService;

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
        algoExpertService.twoNumberSumSolution2(new int[] {3, 5, -4, 8, 11, 1, -1, 6}, 10);

    }
}