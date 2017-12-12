package DP.左大段右小段.linear;
/*
Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
*/
public class BuyStockI {
    public int maxProfit(int[] prices) {
        // write your code here
        if(prices == null || prices.length == 0){
            return 0;
        }
        //思路：现值减最小的值就是profit，所以除了算profit，一定要找到那个最小值
        //注意把min设定为整数最大值
        int min = Integer.MAX_VALUE;
        int profit = 0;

        for(int i : prices){
            //更新min和更新profit
            min = i < min ? i : min;
            profit = (i - min) > profit ? (i - min) : profit;
        }

        return profit;
    }
}
