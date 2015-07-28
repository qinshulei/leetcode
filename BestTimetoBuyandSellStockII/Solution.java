/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

Best Time to Buy and Sell Stock II

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

*/

import java.util.*;

public class Solution {

    public int maxProfit(int[] prices) {
        int sum = 0;
        if (prices.length <= 1){
            return sum;
        }

        for (int i = 1; i < prices.length; i ++){
            int temp = prices[i] - prices[i - 1];
            if ( temp > 0) {
                sum = sum + temp;
            }
        }

        return sum;
    }

    public static void main(String[] args){

    }
}
