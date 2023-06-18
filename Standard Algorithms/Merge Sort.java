/**
 * Intuition - Partition the given array recursively in halves until the partition
 * size becomes 1. Then start merging adjacent partitions in a sorted order. This
 * is done recursively to ensure that after every merge, the partition is sorted.
 * Consider [5,9,11,2,23,6,15,8,1]
 * The entire array is taken as the first partition and is then split in halves.                __
 *                                    [5,9,11,2,23,6,15,8,1]                                      |
 *                                /                            \                                  |
 *                  [5,9,11,2,23]                                   [6,15,8,1]                    |
 *                 /            \                                 /             \                 |
 *          [5,9,11]            [2,23]                       [6,15]              [8,1]            |  => Partition phase
 *          /       \           /     \                     /       \           /     \           |
 *      [5,9]       [11]      [2]     [23]                [6]       [15]       [8]     [1]        |
 *      /   \        |        |        |                   |          |         |       |         |
 *    [5]   [9]      |        |        |                   |          |         |       |       __|
 *      \   /        |        |        |                   |          |         |       |
 *      [5,9]       [11]     [2]      [23]                [6]       [15]       [8]     [1]      __
 *          \       /           \       /                    \       /           \      /         |
 *          [5,9,11]             [2,23]                        [6,15]              [1,8]          |
 *                  \             /                                   \             /             |
 *                   [2,5,9,11,23]                                       [1,6,8,15]               | => Merge phase
 *                                    \                               /                           |
 *                                        [1,2,5,6,8,9,11,15,23]                                __|
 *
 * Algorithm is stable and can be parallelised.
 * It is not in-place as it requires additional arrays. 
 * 
 * However, it can be used without extra space for sorting linked lists. Merge Sort is ideal for sorting linked lists
 * as it sequentiality accesses data without the need for random access of elements. Hence, Merge Sort can be applied
 * without the need for auxiliary arrays as creation and deletion of a node takes O(1) time and elements can be easily
 * swapped in given array during merge phase.
 *
 * Time complexity - O(n * logn)
 * Space complexity - O(n)
 */
class Solution {
  public static void main(String[] args) {
    int[] arr = new int[] {5,9,11,2,23,6,15,8,1};

    mergeSort(arr, 0, arr.length - 1);

    System.out.println("Sorted array: ");
    for(int num : arr) {
      System.out.print(num + " ");
    }
  }

  public static void mergeSort(int[] arr, int start, int end) {
    if(start < end) {
      int mid = (start + end) / 2;
      
      // Split the current partition in halves
      mergeSort(arr, start, mid);
      mergeSort(arr, mid + 1, end);

      // Merge the two partitions
      merge(arr, start, mid, end);
    }
  }

  public static void merge(int[] arr, int start, int mid, int end) {
    // Two temporary arrays to hold the partitions
    int[] l1 = new int[mid - start + 1];
    int[] l2 = new int[end - mid];

    // Populate the temporary arrays
    int m = 0;
    for(int i = start; i <= mid; i++) {
      l1[m++] = arr[i];
    }

    int n = 0;
    for(int i = mid + 1; i <= end; i++) {
      l2[n++] = arr[i];
    }

    // Merge the sorted arrays
    int i = 0;
    int j = 0;
    int k = start;
    while(i < l1.length && j < l2.length) {
      if(l1[i] < l2[j]) {
        arr[k++] = l1[i++];
      }
      else {
        arr[k++] = l2[j++];
      }
    }

    // If l1 has more elements, copy as it is to arr
    while(i < l1.length) {
      arr[k++] = l1[i++];
    }

    // If l2 has more elements, copy as it is to arr
    while(j < l2.length) {
      arr[k++] = l2[j++];
    }
  }
}
