// Link to problem - https://leetcode.com/problems/all-elements-in-two-binary-search-trees/description/

/**
 * Intuition - Traverse both trees in inorder to get two sorted lists.
 * Merge these lists using merge algorithm to combine them.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        // Get the sorted list for both trees using inorder
        inorder(root1, l1);
        inorder(root2, l2);

        // Merge both lists
        int i = 0;
        int j = 0;
        while(i < l1.size() && j < l2.size()) {
            if(l1.get(i) < l2.get(j)) {
                result.add(l1.get(i));
                i++;
            }
            else {
                result.add(l2.get(j));
                j++;
            }
        }
        while(i < l1.size()) {
            result.add(l1.get(i));
            i++;
        }
        while(j < l2.size()) {
            result.add(l2.get(j));
            j++;
        }

        return result;
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if(root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
