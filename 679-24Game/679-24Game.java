// Last updated: 22/09/2025, 16:15:52
class Solution {
    private static final double TARGET = 24;
    private static final double EPSILON = 1e-6;

    public boolean judgePoint24(int[] cards) {
        double[] nums = new double[cards.length];
        for (int i = 0; i < cards.length; i++) {
            nums[i] = cards[i];
        }
        return helper(nums);
    }

    private boolean helper(double[] nums) {
        int n = nums.length;
        if (n == 1) {
            return Math.abs(nums[0] - TARGET) < EPSILON;
        }

        // Try every pair of numbers
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    double[] nextNums = new double[n - 1];
                    int index = 0;
                    for (int k = 0; k < n; k++) {
                        if (k != i && k != j) {
                            nextNums[index++] = nums[k];
                        }
                    }

                    // Try all operations between nums[i] and nums[j]
                    double a = nums[i], b = nums[j];

                    // Addition
                    nextNums[index] = a + b;
                    if (helper(nextNums)) return true;

                    // Subtraction
                    nextNums[index] = a - b;
                    if (helper(nextNums)) return true;

                    nextNums[index] = b - a;
                    if (helper(nextNums)) return true;

                    // Multiplication
                    nextNums[index] = a * b;
                    if (helper(nextNums)) return true;

                    // Division (avoid division by zero)
                    if (Math.abs(b) > EPSILON) {
                        nextNums[index] = a / b;
                        if (helper(nextNums)) return true;
                    }
                    if (Math.abs(a) > EPSILON) {
                        nextNums[index] = b / a;
                        if (helper(nextNums)) return true;
                    }
                }
            }
        }
        return false;
    }
}
