// Link to problem - https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/931/

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
