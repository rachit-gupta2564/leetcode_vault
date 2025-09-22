// Last updated: 22/09/2025, 16:15:55
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int maxWidth = 0;

        // Queue stores pairs of (node, index)
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();
            int start = queue.peek().getValue(); // leftmost index at this level
            int end = start; // initialize rightmost index

            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> pair = queue.poll();
                TreeNode node = pair.getKey();
                int index = pair.getValue() - start; // normalize to prevent overflow
                end = index;

                if (node.left != null) queue.offer(new Pair<>(node.left, 2 * index + 1));
                if (node.right != null) queue.offer(new Pair<>(node.right, 2 * index + 2));
            }

            maxWidth = Math.max(maxWidth, end + 1);
        }

        return maxWidth;
    }
}
