// Link to problem - https://leetcode.com/problems/find-median-from-data-stream/description/

/**
 * Approach 1 - Insertion Sort O(n^2)
 * Since data is constantly changing, Insertion Sort would be a good sorting algorithm to handle it.
 * Insertion Sort sorts one element at the end of each iteration. Hence, when new data comes along,
 * it does not need to be re-done from scratch and that element can be added to its position in O(n)
 * time. Hence, to sort n elements, time complexity is O(n^2).
 *
 * Approach 2 - Heaps O(nlogn)
 * Since data needs to be sorted, we can use two heaps to maintain the left and right side of median.
 * The left side of median is stored in max heap, so the highest element, lower than median is at the
 * top and the right side of median is stored in min heap, so the lowest element, greater than median
 * is stored at the top.
 *
 * If both heaps are the same size and contain odd number of elements - median is average of top elements
 * If left heap has even elements (n - 1) and right heap has odd elements (n) - median is top of right
 * If left heap has odd elements (n) and right heap has even elements (n - 1) - median is top of left
 *
 * When a new element is to be added, ensure that the heap sizes do not have a difference greater than 1.
 * If element > median => push to min (right) heap
 * If element < median => push to max (left) heap
 *
 * NOTE: Solve follow-up for elements with same values in data stream.
 */
class MedianFinder {

    PriorityQueue<Integer> maxHeap;     // Left of median
    PriorityQueue<Integer> minHeap;     // Right of median

    class MaxComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            if(a < b) {
                return 1;
            }
            else if(a > b) {
                return -1;
            }
            return 0;
        }
    }

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(new MaxComparator());
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(maxHeap.size() == minHeap.size() && maxHeap.size() != 0) {
            if(num > maxHeap.peek()) {
                minHeap.add(num);
            }
            else {
                maxHeap.add(num);
            }
        }
        else if(maxHeap.size() > minHeap.size()) {
            if(num > maxHeap.peek()) {
                // Add num to minHeap to maintains heap size difference of 1
                minHeap.add(num);
            }
            else {
                // Move the top to maxHeap to minHeap maintain heaps size difference of 1, then add num
                minHeap.add(maxHeap.poll());
                maxHeap.add(num);
            }
        }
        else if(maxHeap.size() < minHeap.size()) {
            if (num > minHeap.peek()) {
                // Move the top to minHeap to maxHeap maintain heaps size difference of 1, then add num
                maxHeap.add(minHeap.poll());
                minHeap.add(num);
            }
            else {
                // Add num to minHeap to maintains heap size difference of 1
                maxHeap.add(num);
            }
        }
        else {
            // Both heaps are empty
            maxHeap.add(num);
        }
    }
    
    public double findMedian() {
        if(maxHeap.size() == minHeap.size()) {
            // Median is the average of top of heaps
            return ((maxHeap.peek() + minHeap.peek()) / 2.0);
        }
        else if(maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        else {
            return minHeap.peek();
        }
    }
}
