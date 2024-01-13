// Link to problem - https://www.geeksforgeeks.org/problems/merge-two-binary-max-heap0144/1

/**
 * Intuition - Since we have been given two max heaps, they can be directly
 * scanned through and a new max heap can be built by arranging the elements
 * in a descending order.
 *
 * Time complexity - O(m + n)
 * Space complexity - O(m + n)
 */
class Solution {
    public int[] mergeHeaps(int[] a, int[] b, int n, int m) {
        int[] heap = new int[n + m];
        int i = 0;
        int j = 0;
        int k = 0;
        
        while(i < n && j < m) {
            if(a[i] > b[j]) {
                heap[k++] = a[i++];
            }
            else {
                heap[k++] = b[j++];
            }
        }
        while(i < n) {
            heap[k++] = a[i++];
        }
        while(j < m) {
            heap[k++] = b[j++];
        }
        
        return heap;
    }
}
