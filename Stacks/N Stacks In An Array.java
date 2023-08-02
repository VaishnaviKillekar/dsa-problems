// Link to problem - https://www.codingninjas.com/studio/problems/n-stacks-in-an-array_1164271

/**
 * Intuition - Use an array of linked lists to store the individual stacks at each index.
 * Also maintain a 'count' to determine if the number of elements has reached maximum
 * capacity arraySize. When an element has to be pushed into 'm'th stack, check if capacity
 * is available and add it to the front of the linked list at that index. If the list is
 * not initialised, then initialise and add the element. If capacity is reached, return
 * false.
 *
 * NOTE: Revisit another approach without linked list where multiple stacks are maintained in the
 * array without additional data structures. [https://www.youtube.com/watch?v=lrSXKLmnMV8]
 *
 * Time complexity - O(no. of operations)
 * Space complexity - O(S)
 */
public class NStack {
    LinkedList<Integer>[] arr;
    int arraySize;
    int count;

    // Initialize your data structure.
    public NStack(int N, int S) {
        arr = new LinkedList[N];
        arraySize = S;
        count = 0;
    }

    // Pushes 'X' into the Mth stack. Returns true if it gets pushed into the stack, and false otherwise.
    public boolean push(int x, int m) {
        if(count == arraySize) {
            // Capacity exhausted
            return false;
        }
        LinkedList list = arr[m - 1];
        if(list == null) {
            list = new LinkedList();
        }
        list.addFirst(x);
        arr[m - 1] = list;
        count++;
        return true;
    }

    // Pops top element from Mth Stack. Returns -1 if the stack is empty, otherwise returns the popped element.
    public int pop(int m) {
        if(arr[m - 1] == null || arr[m - 1].size() == 0) {
            return -1;
        }
        count--;
        return arr[m - 1].pollFirst();
    }
}
