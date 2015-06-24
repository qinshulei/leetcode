/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

Best Time to Buy and Sell Stock

Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

这题我还是写复杂了。只需要保存到目前为止的最低价，然后由于时光不能倒退，因此继续用后面的高价去减就可以了。
我的方法在运行速度上应该差距不是太大，但是毕竟拷贝了中间结果。使用了额外空间。
*/

import java.util.*;

public class Solution {

    public int maxProfit(int[] prices) {
        int[] lows = new int[prices.length];
        int[] maxs = new int[prices.length];
        for(int i = 0; i < prices.length; i++){
            int j = prices.length - 1 - i;
            if (i == 0){
                lows[i] = prices[i];
                maxs[j] = prices[j];
            } else {
                if (prices[i] < lows[i - 1]) {
                    lows[i] = prices[i];
                } else {
                    lows[i] = lows[i - 1];
                }

                if (prices[j] > maxs[j + 1]){
                    maxs[j] = prices[j];
                } else {
                    maxs[j] = maxs[j + 1];
                }
            }
        }

        int max = 0;
        for (int i = 0; i < prices.length ; i++){
            int temp_max = maxs[i] - lows[i];
            if (temp_max > max){
                max = temp_max;
            }
        }

        return max;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println("100 : " + s.maxProfit(new int[]{4,3,1,5,9,1,100,101,90}));
    }
}
