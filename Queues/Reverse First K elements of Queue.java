// Link to problem - https://practice.geeksforgeeks.org/problems/reverse-first-k-elements-of-queue/1

/**
 * Intuition - Use stack to reverse the first k elements of queue. Then add these elements to the
 * back of queue. Now to bring them to the front, remove the first n - k elements from the front
 * of the queue and add them to the back.
 *
 * Time complexity - O(n)
 * Space complexity - O(k)
 */
class GfG {
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        Stack<Integer> stack = new Stack<>();
        
        // Remove first k elements from q and add to stack
        for(int i = 0; i < k; i++) {
            stack.add(q.remove());
        }
        
        // Add the stack elements to back of queue - order is reversed due to stack
        while(!stack.isEmpty()) {
            q.add(stack.pop());
        }
        
        // Bring the last k elements to front of queue - remove first n-k from front
        // and add to back of queue
        for(int i = 0; i < q.size() - k; i++) {
            q.add(q.remove());
        }
        
        return q;
    }
}
