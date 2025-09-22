// Last updated: 22/09/2025, 16:14:46
class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] maxFreq = new int[26];
        for (String b : words2) {
            int[] freqB = new int[26];
            for (char c : b.toCharArray()) freqB[c - 'a']++;
            for (int i = 0; i < 26; i++) maxFreq[i] = Math.max(maxFreq[i], freqB[i]);
        }
        List<String> res = new ArrayList<>();
        outer:
        for (String a : words1) {
            int[] freqA = new int[26];
            for (char c : a.toCharArray()) freqA[c - 'a']++;
            for (int i = 0; i < 26; i++) {
                if (freqA[i] < maxFreq[i]) continue outer;
            }
            res.add(a);
        }
        return res;
    }
}
