// Link to problem - https://www.codingninjas.com/studio/problems/circular-queue_1170058

public class CircularQueue {
	int[] queue;
	int front = 0;	// Remove element at front
	int rear = -1;	// Add element by incrementing rear
	int count = 0;

	// Initialize your data structure.
	public CircularQueue(int n) {
		queue = new int[n];
	}

	public boolean enqueue(int value) {
		if(count == queue.length) {
			return false;
		}
		count++;
		rear = (rear + 1) % queue.length;
		queue[rear] = value;
		return true;
	}

	public int dequeue() {
		if(count == 0) {
			return -1;
		}
		count--;
		int element = queue[front];
		front = (front + 1) % queue.length;
		return element;
	}
}
