// Last updated: 20/09/2025, 00:32:51
public class Solution {
    public int maxProfit(int[] prices) {
        int firstBuy = Integer.MAX_VALUE;
        int firstProfit = 0;
        int secondBuy = Integer.MAX_VALUE;
        int secondProfit = 0;
        for (int p : prices) {
            firstBuy = Math.min(firstBuy, p);
            firstProfit = Math.max(firstProfit, p - firstBuy);
            secondBuy = Math.min(secondBuy, p - firstProfit);
            secondProfit = Math.max(secondProfit, p - secondBuy);
        }
        return secondProfit;
    }
}
