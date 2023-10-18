// Link to problem - https://practice.geeksforgeeks.org/problems/maximum-sum-of-non-adjacent-nodes/1

/**
 * Intuition - To get maximum sum of nodes that are not directly connected, we traverse the
 * nodes in the tree and compute two sum - including and excluding the current node.
 * These sums are then passed up and the process continues until the root is reached again
 * on backtracking.
 * Consider result as an array of two elements - 
 *   result[0] - max sum including current node
 *   result[1] - max sum excluding current node
 * When max sum excluding current node is to be computed, we need to understand that its
 * child node subtree's maximum sum is to be considered. Hence, the child node itself may
 * or may not be taken - to do this, we take maximum sum of both sums of the subtrees when
 * excluding current node.
 * However, when current node is to be included in sum, we only take sum of child nodes
 * where thet are not considered - result[1].
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution
{
    static int getMaxSum(Node root)
    {
        // result[0] - max sum including current node
        // result[1] - max sum excluding current node
        int[] result = getSum(root);
        return Math.max(result[0], result[1]);
    }
    
    static int[] getSum(Node curr)
    {
        if(curr == null) {
            return new int[] {0, 0};
        }
        
        int[] left = getSum(curr.left);
        int[] right = getSum(curr.right);
        
        int sumIncludingCurrNode = curr.data + left[1] + right[1];
        
        // Current node is excluded - so child node's both sum must be considered
        int sumExcludingCurrNode = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        
        return new int[] {sumIncludingCurrNode, sumExcludingCurrNode};
    }
}
