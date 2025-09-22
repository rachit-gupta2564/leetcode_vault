// Last updated: 22/09/2025, 16:16:39
import java.util.Arrays;

class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int radius = 0;
        int i = 0; // pointer for heaters
        for (int house : houses) {
            // Move the heater pointer to the closest heater on the right or equal
            while (i < heaters.length - 1 && heaters[i] + heaters[i+1] <= 2 * house) {
                i++;
            }
            radius = Math.max(radius, Math.abs(heaters[i] - house));
        }
        return radius;
    }
}
