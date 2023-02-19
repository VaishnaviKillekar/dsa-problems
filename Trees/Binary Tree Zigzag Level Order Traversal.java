// Link to problem - https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/

/**
 * Intuition - BFS
 * Start with root and add it to the traversed list as is. At root level, we add nodes from left to right.
 * The next level - root's children are added in reverse order with right first, left second.
 * The order is reversed again for the next level i.e., root's grandchildren. We alternate order using
 * 'reverse'. But every level 'prev' is always traversed from the end to beginning.
 * 
 * Time complexity - O(logn) - confirm
 * Space complexity - O(n^2) - confirm
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<List<TreeNode>> order = new ArrayList<>();

        if(root != null) {
            order.add(Arrays.asList(root));

            traverse(result, order, true);

            // Convert from nodes to values list
            for(List<TreeNode> level : order) {
                List<Integer> temp = new ArrayList<>();
                for(TreeNode curr : level) {
                    temp.add(curr.val);
                }
                result.add(temp);
            }
        }

        return result;
    }

    public void traverse(List<List<Integer>> result, List<List<TreeNode>> order, boolean reverse) {
        List<TreeNode> prev = order.get(order.size() - 1);
        List<TreeNode> next = new ArrayList<>();

        for(int i = prev.size() - 1; i >= 0; i--) {
            TreeNode curr = prev.get(i);
            if(reverse) {
                // Add child nodes from right to left
                addChild(next, curr.right);
                addChild(next, curr.left);
            }
            else {
                // Add child nodes from left to right
                addChild(next, curr.left);
                addChild(next, curr.right);
            }
        }

        if(next.size() == 0) {
            return;
        }
        order.add(next);
        reverse = !reverse;
        traverse(result, order, reverse);
    }

    public void addChild(List<TreeNode> next, TreeNode node) {
        if(node != null) {
            next.add(node);
        }
    }
}
