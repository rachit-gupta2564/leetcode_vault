// Last updated: 22/09/2025, 16:15:07
class Solution {
    public int scoreOfParentheses(String s) {
        java.util.Stack<Integer> st = new java.util.Stack<>();
        st.push(0);
        for (char c : s.toCharArray()) {
            if (c == '(') {
                st.push(0);
            } else {
                int v = st.pop();
                int w = Math.max(2 * v, 1);
                st.push(st.pop() + w);
            }
        }
        return st.pop();
    }
}
