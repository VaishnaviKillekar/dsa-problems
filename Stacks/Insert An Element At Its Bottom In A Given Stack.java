// Link to problem - https://www.codingninjas.com/studio/problems/insert-an-element-at-its-bottom-in-a-given-stack_1171166

/**
 * Intuition - Pop all stack elements and store them into an array. Push the given number x onto stack.
 * Then push all elements from the list back onto stack in reverse order.
 * Alternately, recursion can be used with stack resulting in the same time and space complexity.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
public class Solution 
{
  public static Stack<Integer> pushAtBottom(Stack <Integer> myStack, int x) 
  {
    List<Integer> temp = new ArrayList<>();

    // Empty given stack into temp list
    while(!myStack.isEmpty()) {
      temp.add(myStack.pop());
    }

    // Push x onto empty stack
    myStack.push(x);

    // Push temp elements back onto stack
    int i = temp.size() - 1;
    while(i >= 0) {
      myStack.push(temp.get(i));
      i--;
    }

    return myStack;
  }
}
