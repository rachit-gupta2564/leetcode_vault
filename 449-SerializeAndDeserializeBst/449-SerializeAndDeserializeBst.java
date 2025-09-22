// Last updated: 22/09/2025, 16:17:10
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.*;

class Codec {

    // Encodes a BST to a single string using preorder traversal
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    private void preorder(TreeNode node, StringBuilder sb) {
        if (node == null) return;
        sb.append(node.val).append(",");
        preorder(node.left, sb);
        preorder(node.right, sb);
    }

    // Decodes your encoded data to BST
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        String[] vals = data.split(",");
        Queue<Integer> queue = new LinkedList<>();
        for (String val : vals) {
            queue.offer(Integer.parseInt(val));
        }
        return build(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode build(Queue<Integer> queue, int lower, int upper) {
        if (queue.isEmpty()) return null;
        int val = queue.peek();
        if (val < lower || val > upper) return null;
        queue.poll();
        TreeNode node = new TreeNode(val);
        node.left = build(queue, lower, val);
        node.right = build(queue, val, upper);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
