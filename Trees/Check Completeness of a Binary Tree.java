// Link to problem - https://leetcode.com/problems/check-completeness-of-a-binary-tree/description/

/**
 * Intuition - Do a level order traversal of the binary tree and store the nodes
 * in a 1-D array. Now scan through the array and check if there's a non-null
 * node present after a null node. If yes, then it is not a complete BT.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        List<TreeNode> tree = new ArrayList<>();
        tree.add(root);

        traverse(tree, 0);

        boolean foundNull = false;
        for(int i = 0; i < tree.size(); i++) {
            if(tree.get(i).val != -1 && foundNull) {
                return false;
            }
            else if(tree.get(i).val == -1) {
                foundNull = true;
            }
        }

        return true;
    }

    public void traverse(List<TreeNode> tree, int pos) {
        TreeNode curr = tree.get(pos);
        if(curr.val != -1) {
            tree.add(curr.left != null ? curr.left : new TreeNode(-1));
            tree.add(curr.right != null ? curr.right : new TreeNode(-1));
            traverse(tree, pos + 1);
        }
    }
}
