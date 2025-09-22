// Last updated: 22/09/2025, 16:18:19
import java.util.*;

class Solution {
    public NestedInteger deserialize(String s) {
        if (s.charAt(0) != '[') return new NestedInteger(Integer.parseInt(s));
        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger curr = null;
        int num = 0;
        boolean negative = false;
        boolean numStarted = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '-') {
                negative = true;
            } else if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
                numStarted = true;
            } else if (c == '[') {
                if (curr != null) stack.push(curr);
                curr = new NestedInteger();
            } else if (c == ',' || c == ']') {
                if (numStarted) {
                    curr.add(new NestedInteger(negative ? -num : num));
                    num = 0;
                    negative = false;
                    numStarted = false;
                }
                if (c == ']' && !stack.isEmpty()) {
                    NestedInteger parent = stack.pop();
                    parent.add(curr);
                    curr = parent;
                }
            }
        }
        return curr;
    }
}
