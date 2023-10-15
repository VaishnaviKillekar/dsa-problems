// Link to problem - https://practice.geeksforgeeks.org/problems/k-sum-paths/1

/**
 * TLE
 */
class Solution
{
    public int sumK(Node root,int k)
    {
        List<Integer> path = new ArrayList<>();
        int count = 0;
        return sumPaths(root, k, path, count);
    }
    
    public int sumPaths(Node node, int k, List<Integer> path, int count) {
        if(node == null) {
            return count;
        }
        
        // Add current node to path
        path.add(node.data);
        
        // Traverse current node's left and right subtree
        count = sumPaths(node.left, k, path, count);
        count = sumPaths(node.right, k, path, count);
        
        // Check if path contains sum
        int sum = 0;
        for(int i = path.size() - 1; i >= 0; i--) {
            sum += path.get(i);
            if(sum == k) {
                count++;
            }
        }
        
        // Remove current node from path while backtracking
        path.remove(path.size() - 1);
        
        return count;
    }
}
