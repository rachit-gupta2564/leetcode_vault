// Last updated: 22/09/2025, 16:18:33
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int lo = 1, hi = n;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int g = guess(mid);
            if (g == 0) return mid;
            if (g < 0) hi = mid - 1;
            else lo = mid + 1;
        }
        return -1;
    }
}
