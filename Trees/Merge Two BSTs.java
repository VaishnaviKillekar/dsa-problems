// Link to problem - https://www.codingninjas.com/studio/problems/merge-two-bsts_920474?leftPanelTabValue=PROBLEM

/**
 * Intuition - Get inorder traversal of both BSTs - this returns sorted arrays.
 * Now these arrays are merged using merge sort to get a single sorted array.
 *
 * NOTE - The final sorted array can be used to construct a BST using the concept
 * of constructing BST from inorder traversal which uses Binary Search principle
 * to create nodes.
 * Refer: Trees/Balance a Binary Search Tree.java
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
public class Solution {
    public static List<Integer> mergeBST(TreeNode root1, TreeNode root2) {
        List<Integer> inorder1 = new ArrayList<>();
        List<Integer> inorder2 = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        // Get inorder for both trees
        traverse(root1, inorder1);
        traverse(root2, inorder2);

        // Merge both inorders
        int i = 0;
        int j = 0;
        while(i < inorder1.size() && j < inorder2.size()) {
            if(inorder1.get(i) < inorder2.get(j)) {
                result.add(inorder1.get(i));
                i++;
            }
            else {
                result.add(inorder2.get(j));
                j++;
            }
        }
        while(i < inorder1.size()) {
            result.add(inorder1.get(i));
            i++;
        }
        while(j < inorder2.size()) {
            result.add(inorder2.get(j));
            j++;
        }

        return result;
    }

    public static void traverse(TreeNode root, List<Integer> inorder) {
        if(root == null) {
            return;
        }

        traverse(root.left, inorder);
        inorder.add(root.data);
        traverse(root.right, inorder);
    }
}
