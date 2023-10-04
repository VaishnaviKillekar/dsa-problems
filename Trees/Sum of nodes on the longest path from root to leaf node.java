// Link to problem - https://practice.geeksforgeeks.org/problems/sum-of-the-longest-bloodline-of-a-tree/1

/**
 * Intuition - iterate through the tree using preorder traversal.
 * Add the current node to the sum and height and then get the
 * sum and height of the left and right subtrees. Continue this
 * process using recursion.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution {
    public int sumOfLongRootToLeafPath(Node root)
    {
        int[] result = getLongestPathSum(root, 0, 0);
        return result[1];
    }
    
    public int[] getLongestPathSum(Node node, int height, int sum) {
        if(node == null) {
            return new int[] {height, sum};
        }
        
        // Add current node to path
        height++;
        sum += node.data;
        
        int[] leftPathSum = getLongestPathSum(node.left, height, sum);
        int[] rightPathSum = getLongestPathSum(node.right, height, sum);
        
        if(leftPathSum[0] > rightPathSum[0]) {
            return leftPathSum;
        }
        else if(leftPathSum[0] < rightPathSum[0]) {
            return rightPathSum;
        }
        else if(leftPathSum[1] > rightPathSum[1]) {
            // Equal height, compare sum
            return leftPathSum;
        }
        else {
            return rightPathSum;
        }
    }
}
