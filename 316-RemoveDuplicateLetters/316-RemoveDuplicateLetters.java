// Last updated: 22/09/2025, 16:19:33
class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26]; // count of each character
        boolean[] inStack = new boolean[26]; // whether character is in stack

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            count[idx]--; // one occurrence is used

            if (inStack[idx]) continue; // already in stack, skip

            // pop larger chars that will appear later again
            while (!stack.isEmpty() && stack.peek() > c && count[stack.peek() - 'a'] > 0) {
                char removed = stack.pop();
                inStack[removed - 'a'] = false;
            }

            stack.push(c);
            inStack[idx] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.removeLast()); // reverse stack
        return sb.toString();
    }
}
