package com.hackerRank.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@Slf4j
public class ElectronicsShopService {
    /**
     * A person wants to determine the most expensive computer keyboard and USB drive that can be purchased with a
     * give budget.
     *
     * Given price lists for keyboards and USB drives and a budget, find the cost to buy them.
     *
     * If it is not possible to buy both items, return -1.
     *
     * Example
     *
     * budget=60
     * keyboards[40, 50, 60]
     * drives=[5, 8, 12]
     *
     * The person can buy a $40 keyboard + $12 USB drive = $52 or a $50 keyboard + $8 USB drive = $58.
     * Choose the latter as the more expensive keyboard option and USB drive and return 58.
     *
     * Function Description
     *
     * Complete the getMoneySpent function in the editor below.
     *
     * getMoneySpent has the following parameter(s):
     *
     *     int keyboards[n]: the keyboard prices
     *     int drives[m]: the drive prices
     *     int b: the budget
     *
     * Returns
     *
     * int: the maximum that can be spent, or -1 if it is not possible to buy both items.
     *
     * Input Format
     *
     * The first line contains three space-separated integers b, k, and d, the budget (b), the number of keyboard
     * models (k) and the number of USB drive models (d).
     *
     * The second line contains k space-separated integers keyboards[i], the prices of each keyboard model.
     * The third line contains d space-separated integers drives[j], the prices of the USB drives.
     *
     * Constraints
     *
     * 1<= k,d <=1000
     * 1<= b <= 10 to the 6 (One million)
     * The price of each item is in the inclusive range [1, 10 to the 6 (One million)]
     *
     * Sample Input
     * 10 2 3
     * 3 1
     * 5 2 8
     *
     * 1 3
     * 2 5 8
     *
     * Sample Output
     * 9
     *
     * Buy the second keyboard and the third USB drive for a total cost of 1 + 8 = 9
     *
     * Sample Input
     * 5 1 1
     * 4
     * 5
     *
     * Sample Output
     * -1
     *
     * There is no way to buy one keyboard and one USB drive because 4 + 5 > 5, so return -1
     *
     *
     */

    private final int budgetArray[] = {10, 2, 3};
    private final int keyboardsArray[] = {3, 1};
    private final int usbDrivesArray[] = {5, 2, 8};

    public int getMoneySpent() {
        log.info("ELECTRONICS SHOP***************************************************");
        if(budgetArray.length > 3)
            throw new IllegalArgumentException("Budget array must contain only 3 values: 1st budget, " +
                    "2d keyboard array length and 3d: usb-drives array length");
        log.info("Validating budget constrain: 1<= b <= 10 to the 6 (One million)");
        if(budgetArray[0] < 1 || budgetArray[0] > 1000000)
            throw new IllegalArgumentException("Budget must be: 1<= b <= 10 to the 6 (One million)");

        log.info("Validate keyboards and drives elements: 1<= k,d <=1000");
        if(budgetArray[1] != keyboardsArray.length || budgetArray[2] != usbDrivesArray.length)
            throw new IllegalArgumentException("Mismatch lengths from keyboards and usb drive in budget array");

        log.info("Validate keyboards and drives prices: 1<= k, d (prices) <= 10 to the 6 (One million)");
        for(int i=0; i< budgetArray[1]; i++)
            if(keyboardsArray[i] < 1 || keyboardsArray[i] > 1000000)
                throw new IllegalArgumentException("Keyboards cost not allowed at index: " + i);
        for(int i=0; i< budgetArray[2]; i++)
            if(usbDrivesArray[i] < 1 || usbDrivesArray[i] > 1000000)
                throw new IllegalArgumentException("USB drives cost not allowed at index: " + i);

        Arrays.sort(keyboardsArray);
        Arrays.sort(usbDrivesArray);

        if(keyboardsArray[0] + usbDrivesArray[0] > budgetArray[0]) {
            log.error("-1, Budget: " + budgetArray[0] + " the cheapest keyboard: " + keyboardsArray[0]
                    + " the cheapest usb drive: " + usbDrivesArray[0] + "Not enough budget to buy");
            return -1;
        }

        int maxBudgetToSpend = 0;
        int keyboardIndexToBuy = 0;
        int usbDriveIndexToBuy = 0;
        for(int i = keyboardsArray.length -1; i >= 0; i--) {
            int sum = 0;
            for(int j = usbDrivesArray.length -1; j >= 0; j--) {
                sum = keyboardsArray[i] + usbDrivesArray[j];
                if (sum <= budgetArray[0]) {
                    if(maxBudgetToSpend < sum) {
                        maxBudgetToSpend = sum;
                        keyboardIndexToBuy = i;
                        usbDriveIndexToBuy = j;
                    }
                }
            }
        }
        log.info("With the budget of: " + budgetArray[0] + ", is possible to buy the keyboard with price: "
                + keyboardsArray[keyboardIndexToBuy] + " and the usb drive with price: "
                + usbDrivesArray[usbDriveIndexToBuy]);
        log.info("Result: " + maxBudgetToSpend);
        return maxBudgetToSpend;
    }
}
