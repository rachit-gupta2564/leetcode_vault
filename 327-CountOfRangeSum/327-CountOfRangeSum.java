// Last updated: 22/09/2025, 16:19:23
class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] prefix = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        return countWhileMergeSort(prefix, 0, prefix.length, lower, upper);
    }

    private int countWhileMergeSort(long[] sums, int start, int end, int lower, int upper) {
        if (end - start <= 1) return 0;
        int mid = (start + end) / 2;
        int count = countWhileMergeSort(sums, start, mid, lower, upper) 
                  + countWhileMergeSort(sums, mid, end, lower, upper);

        int j = mid, k = mid;
        long[] cache = new long[end - start];
        int r = 0;
        
        for (int i = start; i < mid; i++) {
            while (k < end && sums[k] - sums[i] < lower) k++;
            while (j < end && sums[j] - sums[i] <= upper) j++;
            count += j - k;
        }

        // Merge step
        int p = start, q = mid, idx = 0;
        while (p < mid && q < end) {
            if (sums[p] <= sums[q]) cache[idx++] = sums[p++];
            else cache[idx++] = sums[q++];
        }
        while (p < mid) cache[idx++] = sums[p++];
        while (q < end) cache[idx++] = sums[q++];
        
        System.arraycopy(cache, 0, sums, start, end - start);
        return count;
    }
}
