package com.hackerRank.utils;

import com.hackerRank.service.PalindromeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AppRunner implements CommandLineRunner {
    @Autowired
    private PalindromeService palindromeService;
    @Override
    public void run(String... args) throws Exception {
        log.info("App started...");

        palindromeService.verifyPalindrome();
    }
}
