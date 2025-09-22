// Last updated: 22/09/2025, 16:15:42
import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                level.add(node.val);
                if (node.children != null) {
                    for (Node child : node.children) {
                        q.offer(child);
                    }
                }
            }
            res.add(level);
        }
        return res;
    }
}
