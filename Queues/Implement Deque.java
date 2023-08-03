// Link to problem - https://www.codingninjas.com/studio/problems/deque_1170059

public class Deque 
{
    LinkedList<Integer> queue;
    int size;

    // Initialize your data structure.
    public Deque(int n) 
    {
        queue = new LinkedList<Integer>();
        size = n;
    }

    // Pushes 'X' in the front of the deque. Returns true if it gets pushed into the deque, and false otherwise.
    public boolean pushFront(int x) 
    {
        // Dequeue is at max capacity
        if(queue.size() == size) {
            return false;
        }
        queue.addFirst(x);
        return true;
    }

    // Pushes 'X' in the back of the deque. Returns true if it gets pushed into the deque, and false otherwise.
    public boolean pushRear(int x) 
    {
        // Dequeue is at max capacity
        if(queue.size() == size) {
            return false;
        }
        queue.addLast(x);
        return true;
    }

    // Pops an element from the front of the deque. Returns -1 if the deque is empty, otherwise returns the popped element.
    public int popFront() 
    {
        // Dequeue is empty
        if(queue.size() == 0) {
            return -1;
        }
        return queue.pollFirst();
    }

    // Pops an element from the back of the deque. Returns -1 if the deque is empty, otherwise returns the popped element.
    public int popRear() 
    {
        // Dequeue is empty
        if(queue.size() == 0) {
            return -1;
        }
        return queue.pollLast();
    }

    // Returns the first element of the deque. If the deque is empty, it returns -1.
    public int getFront() 
    {
        // Dequeue is empty
        if(queue.size() == 0) {
            return -1;
        }
        return queue.peekFirst();
    }

    // Returns the last element of the deque. If the deque is empty, it returns -1.
    public int getRear() 
    {
        // Dequeue is empty
        if(queue.size() == 0) {
            return -1;
        }
        return queue.peekLast();
    }

    // Returns true if the deque is empty. Otherwise returns false.
    public boolean isEmpty() 
    {
        return queue.size() == 0;
    }

    // Returns true if the deque is full. Otherwise returns false.
    public boolean isFull() 
    {
        return queue.size() == size;
    }
}
