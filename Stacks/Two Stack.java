// Link to problem - https://www.codingninjas.com/studio/problems/two-stacks_983634

/**
 * Intuition - Use the array such that stack 1 elements are pushed from left to right
 * and stack 2 elements are pushed right to left until top1 != top2.
 *
 * Time complexity - O(s)
 * Space complexity - O(s)
 */
public class TwoStack {
	int[] arr;
	int top1;
	int top2;

	// Initialize TwoStack.
	public TwoStack(int s) {
		arr = new int[s];
		top1 = -1;
		top2 = s;
	}

	// Push in stack 1.
	public void push1(int num) {
		// Insert only if there is space
		if(top1 + 1 != top2) {
			top1++;
			arr[top1] = num;
		}
	}

	// Push in stack 2.
	public void push2(int num) {
		// Insert only if there is space
		if(top2 - 1 != top1) {
			top2--;
			arr[top2] = num;
		}
	}

	// Pop from stack 1 and return popped element.
	public int pop1() {
		// Pop top element
		if(top1 > -1) {
			return arr[top1--];
		}
		else {
			// underflow
			return -1;
		}
	}

	// Pop from stack 2 and return popped element.
	public int pop2() {
		if(top2 < arr.length) {
			return arr[top2++];
		}
		else {
			// underflow
			return -1;
		}

	}

}
