/**
 * Algorithm to heapify an array to a max heap.
 * Heapify is always done from the last parent node to the root. Leaves
 * are skipped as they are already a heap.
 *
 * Time complexity - O(n)
 * Space complexity - O(n)
 */
class Solution {

  public static void heapify(int[] arr, int curr) {
    int largest = curr; // Assume current index is largest
    int left = 2 * curr;
    int right = 2 * curr + 1;

    // Check if current largest is larger than its children
    if (left < arr.length && arr[largest] < arr[left]) {
      largest = left;
    }
    if (right < arr.length && arr[largest] < arr[right]) {
      largest = right;
    }

    // Swap curr and largest if curr is not largest
    if (curr != largest) {
      int temp = arr[curr];
      arr[curr] = arr[largest];
      arr[largest] = temp;

      // Heapify again since there is a new largest
      heapify(arr, largest);
    }
  }

  public static void main(String[] args) {
    // Heaps are 1-indexed arrays
    int[] arr = new int[] {-1, 50, 55, 53, 52, 54};

    /**
     * Heaps are complete binary tree hence leaves are always start
     * at index n/2 + 1.
     *
     * To convert an array into max heap, we start from the last
     * parent node to root -> n/2 to 1 index.
     */ 
    for (int i = arr.length / 2; i > 0; i--) {
      heapify(arr, i);

      for (int m = 1; m < arr.length; m++) {
        System.out.print(arr[m] + " ");
      }
      System.out.println();
    }
  }
}
