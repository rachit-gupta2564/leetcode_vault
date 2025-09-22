// Last updated: 22/09/2025, 16:13:34
class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        for(int i = 0; i < nums.length; i ++) {
            freq[nums[i]] ++;
        }
        int max = 0;
        for(int i = 1; i < freq.length; i ++) {
            if(freq[i] > max) {
                max = freq[i];
            }
        }
        int sum = 0;
        for(int i = 1; i < freq.length; i ++) {
            if(freq[i] == max) {
                sum += freq[i];
            }
        }
        return sum;
    }
}