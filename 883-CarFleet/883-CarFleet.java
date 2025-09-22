// Last updated: 22/09/2025, 16:15:08
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        java.util.Arrays.sort(cars, (a, b) -> Integer.compare(a[0], b[0]));
        int fleets = 0;
        double lastTime = -1.0;
        for (int i = n - 1; i >= 0; i--) {
            double time = (double)(target - cars[i][0]) / cars[i][1];
            if (time > lastTime) {
                fleets++;
                lastTime = time;
            }
        }
        return fleets;
    }
}
