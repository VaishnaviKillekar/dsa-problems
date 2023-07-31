// Link to problem - https://practice.geeksforgeeks.org/problems/the-celebrity-problem/

/**
 * Intuition - Use Stack to find the potential celebrity
 * All add people 0 through n to the stack. Until stack size becomes 1, compare the top two people
 * and remove the one which knows the other. The element which is retained on stack may or may not
 * have known the one removed. We have to remove at least one so as to avoid infinite looping.
 * 
 * Once stack size becomes 1, verify two conditions to ascertain if the element left is the celebrity -
 * 1. The celebrity knows no one, hence the entire row must contain 0s (ignoring diagonal)
 * 2. The celebrity is knows by all, hence the entire column i must contain 1s (ignoring diagonal)
 * The diagonal is ignored since it refers to the same person.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
        Stack<Integer> stack = new Stack<>();
        
        // All all people to stack
    	for(int i = 0; i < n; i++) {
    	    stack.push(i);
    	}
    	
    	// Check if two people know each other and eliminate them
    	while(stack.size() > 1) {
    	    // Get top two people and verify
    	    int first = stack.pop();
    	    int second = stack.pop();
    	    
    	    // Check if the top two people know each other. We need to keep one person
    	    // popped out of the stack. So we do not verify the else part
    	    // Otherwise, both might know each other and will infinitely stay in stack
    	    if(M[first][second] == 1) {
    	        stack.push(second);  // First knows second, so add second back to stack
    	    }
    	    else {
    	        stack.push(first);  // Second may know first, so add first back to stack
    	    }
    	}
    	
    	// The stack now contains the potential celebrity - verify both conditions
    	// Condition 1: Entire row contains 0s - celebrity knows no one
    	boolean isRowZero = true;
    	for(int i = 0; i < n; i++) {
    	    if(M[stack.peek()][i] != 0) {
    	        isRowZero = false;
    	        break;
    	    }
    	}
    	
    	// Condition 2: Entire column contains 1s - celebrity is known by all
    	boolean isColOne = true;
    	for(int i = 0; i < n; i++) {
    	    if(stack.peek() != i && M[i][stack.peek()] != 1) {
    	        isColOne = false;
    	        break;
    	    }
    	}
    	
    	if(isRowZero && isColOne) {
    	    return stack.pop();
    	}
    	
    	return -1;
    }
}




/**
 * Intuition - Brute Force Approach
 * Iterate through given matrix and verify two conditions to find the celebrity -
 * 1. The celebrity knows no one, hence the entire row must contain 0s (ignoring diagonal)
 * 2. The celebrity is knows by all, hence the entire column i must contain 1s (ignoring diagonal)
 * The diagonal is ignored since it refers to the same person.
 *
 * Time complexity - O(n^2)
 * Space complexity - O(1)
 */
class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	for(int i = 0; i < n; i++) {
    	    boolean found = true;
    	    // Check if current row is zero - 1st condition for celebrity (knows no one)
    	    for(int j = 0; j < n; j++) {
    	        if(i != j && M[i][j] != 0) {
    	            found = false;
    	            break;
    	        }
    	    }
    	    if(found) {
    	        // Check if ith column has all 1s - 2nd condition for celebrity (all know them)
    	        for(int j = 0; j < n; j++) {
    	            if(i != j && M[j][i] != 1) {
    	                found = false;
    	                break;
    	            }
    	        }
    	    }
    	    
    	    if(found) {
    	        return i;
    	    }
    	}
    	
    	return -1;
    }
}
