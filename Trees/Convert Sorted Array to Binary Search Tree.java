// Link to problem - https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

/*
 * Intuition - Recursive approach
 * Since the array is sorted, the mid of the array becomes the root and the mid of the halves of the array become
 * the left and right child of the root. Similarly, we continuously divide the left half of the array to form the
 * left children and the right half to form the right children.
 *
 * Time complexity - O(n)
 * Space complexity - O(logn)
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return createBST(nums, 0, nums.length - 1);
    }

    public TreeNode createBST(int[] nums, int start, int end) {
        if(start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createBST(nums, start, mid - 1);
        root.right = createBST(nums, mid+1, end);
        return root;
    }
}
