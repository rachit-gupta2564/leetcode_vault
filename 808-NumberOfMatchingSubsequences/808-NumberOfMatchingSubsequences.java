// Last updated: 22/09/2025, 16:15:31
import java.util.ArrayList;
import java.util.List;

class Solution {

    // Helper class to store the word and the current index (position in the word)
    private static class Node {
        String word;
        int index;
        
        Node(String word, int index) {
            this.word = word;
            this.index = index;
        }
    }
    
    public int numMatchingSubseq(String s, String[] words) {
        // Create 26 buckets, one for each lowercase letter.
        List<Node>[] waiting = new List[26];
        for (int i = 0; i < 26; i++) {
            waiting[i] = new ArrayList<>();
        }
        
        // Add each word to its starting bucket based on its first character.
        for (String word : words) {
            waiting[word.charAt(0) - 'a'].add(new Node(word, 0));
        }
        
        int count = 0;
        // Process each character in the string s.
        for (char c : s.toCharArray()) {
            // Get and clear the bucket for the current character.
            List<Node> currentBucket = waiting[c - 'a'];
            waiting[c - 'a'] = new ArrayList<>();
            // Process each node waiting on this character.
            for (Node node : currentBucket) {
                node.index++; // Move to the next character in the word.
                // If the whole word has been matched, increase the count.
                if (node.index == node.word.length()) {
                    count++;
                } else {
                    // Otherwise, move the node to the bucket corresponding to its next needed character.
                    waiting[node.word.charAt(node.index) - 'a'].add(node);
                }
            }
        }
        
        return count;
    }
}