// Link to problem - https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/

/**
 * Intuition - Do an inorder traversal of the tree to get the nodes in a sorted list.
 * Now carry out a two-pointer approach to determine if there exist two nodes whose
 * sum equals k.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> inorder = new ArrayList<>();
        traverse(root, inorder);

        // Use Two-pointer approach to find nodes which sum to k
        int i = 0;
        int j = inorder.size() - 1;
        while(i < j) {
            int sum = inorder.get(i) + inorder.get(j);
            if(sum == k) {
                return true;
            }
            else if(sum > k) {
                j--;
            }
            else {
                i++;
            }
        }

        return false;
    }

    public void traverse(TreeNode root, List<Integer> inorder) {
        if(root == null) {
            return;
        }

        traverse(root.left, inorder);
        inorder.add(root.val);
        traverse(root.right, inorder);
    }
}
