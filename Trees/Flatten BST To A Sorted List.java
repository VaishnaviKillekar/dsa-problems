// Link to problem - https://www.codingninjas.com/studio/problems/flatten-bst-to-a-sorted-list_1169459?leftPanelTabValue=PROBLEM

/**
 * Intuition - Do an Inorder Traversal on given tree to get the nodes in a sorted
 * array. Now make the left child pointers of all nodes as null and make the right
 * child pointers point to next node in the array.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
public class Solution
{
    public static TreeNode<Integer> flatten(TreeNode<Integer> root)
    {
        List<TreeNode<Integer>> inorder = new ArrayList<>();

        traverse(root, inorder);

        // Make all left pointers null and point right to next index node
        for(int i = 0; i < inorder.size() - 1; i++) {
            TreeNode<Integer> curr = inorder.get(i);
            curr.left = null;
            curr.right = inorder.get(i + 1);
        }
        
        TreeNode<Integer> last = inorder.get(inorder.size() - 1);
        last.left = null;
        last.right = null;

        return inorder.get(0);
    }

    public static void traverse(TreeNode<Integer> root, List<TreeNode<Integer>> inorder) {
        if(root == null) {
            return;
        }

        traverse(root.left, inorder);
        inorder.add(root);
        traverse(root.right, inorder);
    }
}
