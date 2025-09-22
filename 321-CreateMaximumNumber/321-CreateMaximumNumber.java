// Last updated: 22/09/2025, 16:19:29
class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int[] res = new int[k];
        for (int i = Math.max(0, k - n); i <= Math.min(k, m); i++) {
            int[] a = maxArray(nums1, i);
            int[] b = maxArray(nums2, k - i);
            int[] candidate = merge(a, b);
            if (greater(candidate, 0, res, 0)) {
                res = candidate;
            }
        }
        return res;
    }
    
    private int[] maxArray(int[] nums, int k) {
        int[] stack = new int[k];
        int top = -1, drop = nums.length - k;
        for (int num : nums) {
            while (top >= 0 && stack[top] < num && drop > 0) {
                top--;
                drop--;
            }
            if (top + 1 < k) {
                stack[++top] = num;
            } else {
                drop--;
            }
        }
        return stack;
    }
    
    private int[] merge(int[] a, int[] b) {
        int n = a.length, m = b.length;
        int[] res = new int[n + m];
        int i = 0, j = 0, r = 0;
        while (i < n || j < m) {
            if (greater(a, i, b, j)) res[r++] = a[i++];
            else res[r++] = b[j++];
        }
        return res;
    }
    
    private boolean greater(int[] a, int i, int[] b, int j) {
        while (i < a.length && j < b.length && a[i] == b[j]) {
            i++; j++;
        }
        return j == b.length || (i < a.length && a[i] > b[j]);
    }
}
