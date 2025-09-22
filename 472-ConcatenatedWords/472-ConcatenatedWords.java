// Last updated: 22/09/2025, 16:16:43
class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> wordSet = new HashSet<>();
        List<String> result = new ArrayList<>();
        Arrays.sort(words, (a, b) -> a.length() - b.length()); // sort by length

        for (String word : words) {
            if (word.isEmpty()) continue;
            if (canForm(word, wordSet)) result.add(word);
            wordSet.add(word);
        }
        return result;
    }

    private boolean canForm(String word, Set<String> wordSet) {
        if (wordSet.isEmpty()) return false;
        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= word.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (!dp[j]) continue;
                if (wordSet.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[word.length()];
    }
}
