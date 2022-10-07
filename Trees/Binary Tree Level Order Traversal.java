// Link to problem - https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/931/

/**
 * Intuition - Use a Queue DS to store the nodes in each level.
 * Poll the first node in queue and add its children to the queue
 * and its value to result as a new level.
 * Repeat this process until all nodes from queue for that level
 * have been polled and their values added to respective levels in result.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        if(root == null) {
            return res;
        }
        
        queue.add(root);
        
        while(!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int nodes = queue.size();
            for(int i = 0; i < nodes; i++) {
                TreeNode curr = queue.poll();
                if(curr.left != null) {
                    queue.add(curr.left);
                }
                if(curr.right != null) {
                    queue.add(curr.right);
                }
                level.add(curr.val);
            }
            res.add(level);
        }
        
        return res;
    }
}


class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> order = new ArrayList<>();
        Queue<TreeNode> visited = new LinkedList<>();
        
        if(root == null) {
            return new ArrayList<>();
        }
        
        if(root.left != null)
            visited.add(root.left);
        if(root.right != null)
            visited.add(root.right);
        order.add(Arrays.asList(root.val));
        
        return traverse(visited, order);
    }
    
    public List<List<Integer>> traverse(Queue<TreeNode> visited, List<List<Integer>> order) {
        if(visited.size() == 0) {
            return order;
        }
        int nodes = visited.size();
        List<Integer> level = new ArrayList<>();
        for(int i = 0; i < nodes; i++) {
            TreeNode curr = visited.remove();
            level.add(curr.val);
            if(curr.left != null)
                visited.add(curr.left);
            if(curr.right != null)
                visited.add(curr.right);
        }
        order.add(level);
        traverse(visited, order);
        return order;
    }
}
