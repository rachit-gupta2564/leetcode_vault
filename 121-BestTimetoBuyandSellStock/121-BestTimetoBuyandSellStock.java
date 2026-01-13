// Last updated: 13/01/2026, 11:43:45
1public class Solution {
2    public int maxProfit(int[] prices) {
3        int minPrice = Integer.MAX_VALUE;
4        int maxProfit = 0;
5        for (int price : prices) {
6            if (price < minPrice) minPrice = price;
7            else if (price - minPrice > maxProfit) maxProfit = price - minPrice;
8        }
9        return maxProfit;
10    }
11}