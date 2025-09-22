// Last updated: 22/09/2025, 16:19:34
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];  // initialize to 0 by default
        int[] indices = new int[n];
        for (int i = 0; i < n; i++) indices[i] = i;
        mergeSort(nums, indices, res, 0, n - 1);
        List<Integer> ans = new ArrayList<>();
        for (int x : res) ans.add(x);
        return ans;
    }
    
    private void mergeSort(int[] nums, int[] indices, int[] res, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(nums, indices, res, left, mid);
        mergeSort(nums, indices, res, mid + 1, right);
        merge(nums, indices, res, left, mid, right);
    }
    
    private void merge(int[] nums, int[] indices, int[] res, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        int rightCount = 0;
        
        while (i <= mid && j <= right) {
            if (nums[indices[j]] < nums[indices[i]]) {
                temp[k++] = indices[j++];
                rightCount++;
            } else {
                res[indices[i]] += rightCount;
                temp[k++] = indices[i++];
            }
        }
        
        while (i <= mid) {
            res[indices[i]] += rightCount;
            temp[k++] = indices[i++];
        }
        
        while (j <= right) {
            temp[k++] = indices[j++];
        }
        
        for (k = 0; k < temp.length; k++) {
            indices[left + k] = temp[k];
        }
    }
}
