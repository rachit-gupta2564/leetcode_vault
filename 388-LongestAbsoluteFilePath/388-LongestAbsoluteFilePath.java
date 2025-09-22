// Last updated: 22/09/2025, 16:18:15
class Solution {
    public int lengthLongestPath(String input) {
        String[] lines = input.split("\n");
        int maxLen = 0;
        // depth -> current path length at that depth
        Map<Integer, Integer> pathLen = new HashMap<>();
        pathLen.put(0, 0);

        for (String line : lines) {
            int depth = 0;
            while (line.startsWith("\t")) {
                depth++;
                line = line.substring(1);
            }
            int currLen = pathLen.get(depth) + line.length() + 1; // +1 for '/'
            pathLen.put(depth + 1, currLen);
            if (line.contains(".")) {
                maxLen = Math.max(maxLen, currLen - 1); // remove last '/'
            }
        }
        return maxLen;
    }
}
