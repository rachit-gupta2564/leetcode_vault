// Last updated: 22/09/2025, 16:14:53
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        java.util.Arrays.sort(people);
        int i = 0, j = people.length - 1, boats = 0;
        while (i <= j) {
            if (people[i] + people[j] <= limit) i++;
            j--;
            boats++;
        }
        return boats;
    }
}
