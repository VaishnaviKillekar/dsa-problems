// Link to problem - https://www.codingninjas.com/studio/problems/reverse-stack-using-recursion_631875

/**
 * Intuition - Reverse the stack and then insert top element at bottom.
 *
 * Consider stack
 * | 1 |
 * | 2 |
 * | 3 |
 * | 4 |
 * | 5 |
 * |---|
 *
 * top = 1: reverse()
 * |         top = 2: reverse()
 * |         |         top = 3: reverse()
 * |         |         |         top = 4: reverse()
 * |         |         |         |         top = 5: reverse()
 * |         |         |         |         |         empty stack - return
 * |         |         |         |         insertAtBottom(5)
 * |         |         |         |         []  -  push 5    -> [5]
 * |         |         |         insertAtBottom(4)
 * |         |         |         [5]  -  push 4    -> [5, 4]
 * |         |        insertAtBottom(3)
 * |         |        [5, 4]  -  push 3    -> [5, 4, 3]
 * |         insertAtBottom(2)
 * |         [5, 4, 3]  -  push 2    -> [5, 4, 3, 2]
 * insertAtBottom(1)
 * [5, 4, 3, 2]  -  push 1    -> [5, 4, 3, 2, 1]
 *
 * Time complexity - O(n^2)
 * Space complexity - 
 */
public class Solution {
    
	public static void reverseStack(Stack<Integer> stack) {
		if(stack.isEmpty()) {
			return;
		}

		// Get top element
		int top = stack.pop();

		reverseStack(stack);

		// Insert top at bottom of stack
		insertAtBottom(stack, top);

	}

	public static void insertAtBottom(Stack<Integer> stack, int element) {
		// When stack becomes empty - push element at bottom
		if(stack.isEmpty()) {
			stack.push(element);
			return;
		}

		int top = stack.pop();	// Pop top element to empty stack
		insertAtBottom(stack, element);
		stack.push(top);	// Push removed element
	}
}
