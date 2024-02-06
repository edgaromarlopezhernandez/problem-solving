package com.hackerRank.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CatsAndAMouseService {

    /**
     * Two cats and a mouse are at various positions on a line. You will be given their starting positions.
     * Your task is to determine which cat will reach the mouse first, assuming the mouse does not move
     * and the cats travel at equal speed. If the cats arrive at the same time, the mouse will be allowed to move
     * and it will escape while they fight.
     *
     * You are given q queries in the form of x, y and z representing the respective positions for cats A and B,
     * and for mouse C.
     *
     * Complete the function catsAndMouse to return the appropriate answer to each query, which will be printed
     * on a new line.
     * If cat A catches the mouse first, print Cat A.
     * If cat B catches the mouse first, print Cat B.
     * If both cats reach the mouse at the same time, print Mouse C as the two cats fight and mouse escapes.
     *
     * Example
     * x = 2
     * y = 5
     * z = 4
     *
     * The cats are at positions 2 (Cat A) and 5 (Cat B), and the mouse is at position 4. Cat B, at position 5 will
     * arrive first since it is only 1 unit away while the other is 2 units away.
     * Return 'Cat B'.
     *
     * Function Description
     *
     * Complete the catAndMouse function in the editor below.
     * catAndMouse has the following parameter(s):
     *
     * int x: Cat A's position
     * int y: Cat B's position
     * int z: Mouse C's position
     *
     * Returns
     *
     * string: Either 'Cat A', 'Cat B', or 'Mouse C'
     *
     * Input Format
     *
     * The first line contains a single integer, q, denoting the number of queries.
     * Each of the q subsequent lines contains three space-separated integers describing the respective values
     * of x(cat A's location), y(cat B's location), and z(mouse C's location).
     *
     * Constraints
     *
     * 1<= q <=100
     * 1<= x,y,z <=100
     *
     * Sample Input 0
     * 2
     * 1 2 3
     * 1 3 2
     *
     * Sample Output 0
     * Cat B
     * Mouse C
     *
     * Explanation 0
     *
     * Query 0: The positions of the cats and mouse are shown below:
     * Cat A:   1
     * Cat B:   2
     * Mouse C: 3
     *
     * Cat B will catch the mouse first, so we print Cat B on a new line.
     *
     *
     * Query 1: In this query, cats A and B reach mouse at the exact same time: Cats fight and mouse escapes,
     * we print Mouse C on a new line.
     *
     */

    private final int x = 1;
    private final int y = 2;
    private final int z = 3;

    public String catAndMouse() {
        log.info("CATS AND MOUSE************************");
        //Validate constraints
        if(x < 0 || x > 100 || y < 0 || y > 100 || z < 0 || z > 100)
            throw new IllegalArgumentException("x, y  and z must be: 1<= x,y,z <=100");
        //Calculate cats race
        int catARace = 0;
        int catBRace = 0;

        catARace = z - x;
        if(catARace < 0)
            catARace = catARace * -1;
        catBRace = z - y;
        if(catBRace < 0)
            catBRace = catBRace * -1;

        //Return result
        if(catARace == catBRace){
            log.info("Mouse C");
            return "Mouse C";
        }
        else {
            if(catARace < catBRace) {
                log.info("Cat A");
                return "Cat A";
            } else {
                log.info("Cat B");
                return "Cat B";
            }
        }
    }

    /*public String catAndMouse(int x, int y, int z) {
        log.info("CATS AND MOUSE************************");
        //Validate constraints
        if(x < 0 || x > 100 || y < 0 || y > 100 || z < 0 || z > 100)
            throw new IllegalArgumentException("x, y  and z must be: 1<= x,y,z <=100");
        //Calculate cats race
        int catARace = 0;
        int catBRace = 0;

        catARace = z - x;
        if(catARace < 0)
            catARace = catARace * -1;
        catBRace = z - y;
        if(catBRace < 0)
            catBRace = catBRace * -1;

        //Return result
        if(catARace == catBRace){
            log.info("Mouse C");
            return "Mouse C";
        }
        else {
            if(catARace < catBRace) {
                log.info("Cat A");
                return "Cat A";
            } else {
                log.info("Cat B");
                return "Cat B";
            }
        }
    }*/
}
