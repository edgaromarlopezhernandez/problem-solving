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

    @Override
    public void run(String... args) throws Exception {
        log.info("App started...");

        //palindromeService.verifyPalindrome();
        //marsExplorationService.verifySignalReceivedByEarth();
        //stringSubsequenceService.verify();
        //countStringOccurrences.matchingStringsFirstSolution();
        //countStringOccurrences.matchingStringsBestSolution();
        pangramsService.isPangram();
    }
}