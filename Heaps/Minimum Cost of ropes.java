// Link to problem - https://www.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1

/**
 * Intuition - To get the minimum cost of connecting ropes, we need to pick
 * the smallest two and connect them. Then add the combined rope to the rest
 * and continue picking the smallest two. Repeat this process until all ropes
 * are combined.
 * To get the least two length ropes, we can build a min heap and add the combined
 * ropes back to it until the heap size becomes 1. Sum the cost every time the
 * ropes are combined.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution
{
    long minCost(long arr[], int n) 
    {
        PriorityQueue<Long> heap = new PriorityQueue<>();
        long cost = 0;
        
        // Build a min heap with given array
        for(int i = 0; i < n; i++) {
            heap.offer(arr[i]);
        }
        
        // Compute cost by adding the lowest two rope lengths
        while(heap.size() > 1) {
            long x = heap.poll();
            long y = heap.poll();
            cost += x + y;
            heap.offer(x + y);
        }
        
        return cost;
    }
}
