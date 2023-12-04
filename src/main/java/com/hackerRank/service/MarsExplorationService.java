package com.hackerRank.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MarsExplorationService {
    @Autowired
    private ConfigurableEnvironment environment;
    /**
     * A space explorer's ship crashed on Mars! They send a series of SOS messages to Earth for help.
     * Letters in some of the SOS messages are altered by cosmic radiation during transmission. Given the signal received by Earth as a string, s, determine how many letters of the SOS message have been changed by radiation.
     * Example
     * s='SOSTOT'
     * The original message was SOSSOS. Two of the message's characters were changed in transit.
     *
     * Function Description
     * Complete the marsExploration function in the editor below.
     *
     * marsExploration has the following parameter(s):
     * string s: the string as received on Earth
     * Returns
     *
     * int: the number of letters changed during transmission
     *
     * Input Format
     *
     * There is one line of input: a single string s
     *
     * Constraints
     *
     * 1<= length of s <=99
     * length of s modulo 3=0
     * s will contain only uppercase English letters, ascii[A-Z]
     *
     * Simple input 0
     * SOSSPSSQSSOR
     * Simple output 0
     * 3
     *
     *  s = SOSSPSSQSSOR, and signal length |s|=12. They sent SOS messages (i.e.: 12/3=4).
     *  Expected signal: SOSSOSSOSSOS
     *  Recieved signal: SOSSPSSQSSOR
     *  Difference:          X  X   X
     */

    private final String SIGNAL_RECEIVED_BY_EARTH = "SOSSPSSQSSOR";
    private final String EXPECTED_SIGNAL = "SOS";

    public void verifySignalReceivedByEarth() {
        if(SIGNAL_RECEIVED_BY_EARTH.length()%3 != 0)
            throw new IllegalArgumentException("Invalid signal");

        int aux = 0;
        int difference = 0;
        for(int i = 0; i<SIGNAL_RECEIVED_BY_EARTH.length(); i ++) {
            log.info("i: " + i);
            log.info("aux: " + aux);
            log.info("difference: " + difference);
            log.info("Signal received at char i: " + SIGNAL_RECEIVED_BY_EARTH.charAt(i));
            log.info("Expected signal at char i: " + EXPECTED_SIGNAL.charAt(aux));
            if(SIGNAL_RECEIVED_BY_EARTH.charAt(i) != EXPECTED_SIGNAL.charAt(aux)){
                difference += 1;
                log.info("Incrementing difference: " + difference);
            }
            aux += 1;
            if(aux == EXPECTED_SIGNAL.length())
                aux = 0;
        }

        log.info("Message received by earth: " + SIGNAL_RECEIVED_BY_EARTH);
        log.info("RESULT\n");
        log.info("Difference: " + difference);
    }

    private boolean isRunningInDebbug(ConfigurableEnvironment environment, String property) {
        String value = environment.getProperty(property);
        return (value != null && !value.equals("false"));
    }
}
