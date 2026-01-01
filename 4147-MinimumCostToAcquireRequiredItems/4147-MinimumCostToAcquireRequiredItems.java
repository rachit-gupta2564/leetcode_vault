// Last updated: 01/01/2026, 18:32:11
class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long c = Math.min(need1, need2);
        long e1 = need1 - c;
        long e2 = need2 - c;
        long cCost = Math.min(costBoth, cost1+cost2);
        long e1Cost = Math.min(cost1, costBoth);
        long e2Cost = Math.min(cost2, costBoth);

        return c * cCost + e1 * e1Cost + e2 * e2Cost;
    }
}