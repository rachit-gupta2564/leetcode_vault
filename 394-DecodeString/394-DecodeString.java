// Last updated: 22/09/2025, 16:18:07
import java.util.*;

class Solution {
    public String decodeString(String s) {
        Stack<Integer> counts = new Stack<>();
        Stack<StringBuilder> resultStack = new Stack<>();
        StringBuilder curr = new StringBuilder();
        int k = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                counts.push(k);
                resultStack.push(curr);
                curr = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                StringBuilder temp = curr;
                curr = resultStack.pop();
                int repeat = counts.pop();
                for (int i = 0; i < repeat; i++) curr.append(temp);
            } else {
                curr.append(c);
            }
        }
        return curr.toString();
    }
}
