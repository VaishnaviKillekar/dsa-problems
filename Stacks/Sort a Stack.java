// Link to problem - https://www.codingninjas.com/studio/problems/sort-a-stack_985275

/**
 * Intuition - Empty stack using recursion one element at a time.
 * Once stack is empty, insert popped elements in a sorted order.
 * Use another recursive function 'insert' which compares the current
 * element 'curr' to be inserted with top. If it is greater than 'top',
 * then insert 'curr'. Otherwise, recursively call 'insert' until 'top'
 * is less than or equal to 'curr' and then insert.
 *
 * Time complexity - O(n^2)
 * Space complexity - O(n)
 */
public class Solution {

	public static void sortStack(Stack<Integer> stack) {
		if(stack.isEmpty()) {
			// Insert popped elements in sorted way
			return;
		}

		// Remove top
		int top = stack.pop();

		// Recursive call to empty stack
		sortStack(stack);

		// Insert sorted
		insert(stack, top);
	}

	public static void insert(Stack<Integer> stack, int curr) {
		if(stack.isEmpty()) {
			stack.push(curr);
			return;
		}

		// Compare stack top and curr element
		if(stack.peek() <= curr) {
			// Already in order
			stack.push(curr);
		}
		else {
			// Insert in correct order recursively
			int top = stack.pop();	// Remove top to compare curr with rest of stack
			insert(stack, curr);
			stack.push(top);	// Re-insert top
		}
	}
}
