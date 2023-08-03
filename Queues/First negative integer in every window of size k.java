// Link to problem - https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1

/**
 * Intuition - Use a queue to store the indexes of negative elements in current window.
 * For every window, take the first index from queue and add that element to result.
 * If window is empty, add 0 to result. Slide window and remove the front index if it is
 * out of window range and add the last element's index of new window if it is negative.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Compute {
    
    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        List<Long> negatives = new ArrayList<>();
        Queue<Integer> window = new LinkedList<>();
        
        // Add negative element indexes of first window
        for(int i = 0; i < K; i++) {
            if(A[i] < 0) {
                window.add(i);   
            }
        }
        
        // Slide window through array and find the first negative using window
        int left = 0;
        int right = K - 1;
        while(right < N) {
            // Get index of first negative in window
            if(window.size() == 0) {
                // No nogatives in current window
                negatives.add(0L);
            }
            else {
                // Add the first negative from current window
                negatives.add(A[window.peek()]);
            }
            
            // Slide window by one position
            left++;
            right++;
            
            // Remove the front index from window if it is out of range
            if(window.size() > 0 && window.peek() < left) {
                window.remove();
            }
            
            // Add the element index at right if it is negative
            if(right < N && A[right] < 0) {
                window.add(right);
            }
        }
        
        return negatives.stream().mapToLong(i -> i).toArray();
    }
}
