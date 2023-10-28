// Link to problem - https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/description/

/**
 * Intuition - Create a child to parent mapping of nodes. This will help
 * mark parent as infected. While creating this mapping, return the target
 * node so infection can be started there at time 0.
 *
 * While infecting nodes, start with target node in a queue and get all its
 * neighbours - left child, right child and parent (using child to parent map).
 * If any of them is infected, mark the `spread` flag as true to increment time.
 *
 * Before processing a node, always check if it is visited. If yes, then skip it.
 * If not, then infect it, mark `spread` as true and add that node to queue.
 * To know how many nodes are to be infected in same time slot, we iterate queue
 * only until its original size before new additions are made.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution {
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> childParent = new HashMap<>();

        // Create child to parent mapping and get start node 
        TreeNode target = mapChildToParent(root, childParent, start, null);
        System.out.println("start - " + target.val + " childToParent - " + childParent);

        return infectTree(target, childParent);
    }

    public int infectTree(TreeNode target, Map<TreeNode, TreeNode> childParent) {
        Queue<TreeNode> q = new LinkedList<>();
        Map<TreeNode, Boolean> visited = new HashMap<>();
        int time = 0;

        // Add target to queue and mark it as visited
        q.add(target);
        visited.put(target, true);

        while(!q.isEmpty()) {
            int size = q.size();
            boolean spread = false;     // This flag helps track if new nodes were infected

            // Get all neighbours of nodes in queue and mark as visited
            for(int i = 0; i < size; i++) {
                TreeNode curr = q.remove();
                if(curr.left != null && (visited.get(curr.left) == null || !visited.get(curr.left))) {
                    spread = true;
                    q.add(curr.left);
                    visited.put(curr.left, true);
                }
                if(curr.right != null && (visited.get(curr.right) == null || !visited.get(curr.right))) {
                    spread = true;
                    q.add(curr.right);
                    visited.put(curr.right, true);
                }
                if(childParent.get(curr) != null && (visited.get(childParent.get(curr)) == null || !visited.get(childParent.get(curr)))) {
                    spread = true;
                    q.add(childParent.get(curr));
                    visited.put(childParent.get(curr), true);
                }
            }

            // If infection spread, then increment time as all neighbouring nodes were infected in same time
            if(spread) {
                time++;
            }
        }

        return time;
    }

    public TreeNode mapChildToParent(TreeNode root, Map<TreeNode, TreeNode> childParent, int start, TreeNode target) {
        if(root.val == start) {
            target = root;
        }

        if(root.left != null) {
            childParent.put(root.left, root);
            target = mapChildToParent(root.left, childParent, start, target);
        }

        if(root.right != null) {
            childParent.put(root.right, root);
            target = mapChildToParent(root.right, childParent, start, target);
        }

        return target;
    }
}
