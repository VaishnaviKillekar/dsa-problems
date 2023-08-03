// Link to problem - https://practice.geeksforgeeks.org/problems/queue-reversal/1

/**
 * Intuition - Use stack to reverse the queue elements and then add them back to queue.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class GfG {
    public Queue<Integer> rev(Queue<Integer> q) {
        Stack<Integer> stack = new Stack<>();
        
        // Push elements onto stack to reverse order
        while(q.size() > 0) {
            stack.add(q.remove());
        }

        // Put reversed stack elements back into queue
        while(!stack.isEmpty()) {
            q.add(stack.pop());
        }
        
        return q;
    }
}
