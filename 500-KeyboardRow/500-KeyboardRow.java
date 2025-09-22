// Last updated: 22/09/2025, 16:16:15
import java.util.*;

class Solution {
    public String[] findWords(String[] words) {
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        Set<Character> set3 = new HashSet<>();
        
        for (char c : row1.toCharArray()) set1.add(c);
        for (char c : row2.toCharArray()) set2.add(c);
        for (char c : row3.toCharArray()) set3.add(c);
        
        List<String> result = new ArrayList<>();
        
        outer:
        for (String word : words) {
            String lower = word.toLowerCase();
            Set<Character> rowSet = null;
            
            if (set1.contains(lower.charAt(0))) rowSet = set1;
            else if (set2.contains(lower.charAt(0))) rowSet = set2;
            else rowSet = set3;
            
            for (char c : lower.toCharArray()) {
                if (!rowSet.contains(c)) continue outer;
            }
            
            result.add(word);
        }
        
        return result.toArray(new String[0]);
    }
}
