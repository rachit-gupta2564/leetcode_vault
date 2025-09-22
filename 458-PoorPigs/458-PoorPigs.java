// Last updated: 22/09/2025, 16:16:58
class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int pigs = 0;
        int states = minutesToTest / minutesToDie + 1;
        while (Math.pow(states, pigs) < buckets) {
            pigs++;
        }
        return pigs;
    }
}
