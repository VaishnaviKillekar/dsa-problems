// Link to problem - https://www.codingninjas.com/studio/problems/delete-middle-element-from-stack_985246

/**
 * Intuition - Use another stack to hold the popped elements from given stack
 * temporarily. Then remove the middle element and push back elements from 'temp'
 * into given input stack.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
public class Solution {
	public static void deleteMiddle(Stack<Integer> inputStack, int N) {
		Stack<Integer> temp = new Stack<>();
		int popCount = N % 2 == 0 ? (N / 2) - 1 : N / 2;

		while(popCount > 0) {
			temp.push(inputStack.pop());
			popCount--;
		}

		// Remove the middle element
		inputStack.pop();

		// Add the removed stack elements
		while(temp.size() > 0) {
			inputStack.push(temp.pop());
		}
	}
}
