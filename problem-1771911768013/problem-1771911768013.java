// Last updated: 24/02/2026, 11:12:48
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    public int sumRootToLeaf(TreeNode root) {
18        return dfs(root, 0);
19    }
20
21    private int dfs(TreeNode node, int cur) {
22        if (node == null) return 0;
23
24        cur = (cur << 1) | node.val; // append this bit
25
26        if (node.left == null && node.right == null) {
27            return cur; // leaf => one complete binary number
28        }
29
30        return dfs(node.left, cur) + dfs(node.right, cur);
31    }
32}