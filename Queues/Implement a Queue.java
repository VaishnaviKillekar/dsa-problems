// Link to problem - https://www.codingninjas.com/studio/problems/queue-using-array-or-singly-linked-list_2099908

public class Queue {
    LinkedList<Integer> queue;

    Queue() {
        queue = new LinkedList<Integer>();
    }

    /*----------------- Public Functions of Queue -----------------*/

    boolean isEmpty() {
        return queue.size() == 0;
    }

    void enqueue(int data) {
        queue.addLast(data);
    }

    int dequeue() {
        return queue.size() > 0 ? queue.pollFirst() : -1;
    }

    int front() {
        return queue.size() > 0 ? queue.peek() : -1;
    }

}
