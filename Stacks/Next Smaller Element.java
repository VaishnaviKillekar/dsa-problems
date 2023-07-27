// Link to problem - https://www.codingninjas.com/studio/problems/next-smaller-element_1112581

/**
 * Intuition - Iterate the given array from back to front. Compare current element with stack top.
 * If stack is smaller, then put stack top in the result for current index, push the current
 * element onto stack. If stack top is greater than or equal to current, then pop stack top until
 * a smaller element is found at top. Copy that stack top in the result for current index and push
 * current element onto stack.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
public class Solution{
    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n){
        Integer[] result = new Integer[n];
        Stack<Integer> stack = new Stack<>();

        // Last element has no right smaller element
        result[n - 1] = -1;
        stack.push(-1);

        for(int i = n - 1; i >= 0; i--) {
            int curr = arr.get(i);
            // Stack top is smaller than current
            if(stack.peek() < curr) {
                result[i] = stack.peek();
            }
            else {
                // Stack top is greater - pop until small element is found
                while(stack.peek() >= curr) {
                    stack.pop();
                }
                result[i] = stack.peek();
            }
            stack.push(curr);
        }

        return new ArrayList<Integer>(Arrays.asList(result));
    }
}
