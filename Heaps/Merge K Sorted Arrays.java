// Link to problem - https://www.codingninjas.com/studio/problems/merge-k-sorted-arrays_975379

/**
 * Intuition - Since the arrays are already sorted, we use a min heap to store the elements at index 0 for all arrays.
 * This leaves us with a heap of size k. Now we poll the elements from heap to get the least values in order to sort
 * the elements into final result. Since these elements belong to arrays, we also need to track their array and their
 * index inside that array. To achieve this, we create a custom class to store three details - value, array, index.
 * As a result, a custom comparator is also required.
 *
 * Time complexity - O(n*klogk) - heap size is k and insert and poll takes logk time. We do this for all n*k elements
 * Space complexity - O(k)
 */
public class Solution 
{
	public static class HeapElement
	{
		int value;	// Value of element in list
		int list;	// The list which it belongs to
		int index;	// Index in the list

		HeapElement() {}

		HeapElement(int value, int list, int index)
		{
			this.value = value;
			this.list = list;
			this.index = index;
		}
	}

	public static class HeapComparator implements Comparator<HeapElement>
	{
		@Override
		public int compare(HeapElement a, HeapElement b)
		{
			if(a.value < b.value)
			{
				return -1;
			}
			else if(a.value > b.value)
			{
				return 1;
			}
			return 0;
		}
	}

	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
	{
		ArrayList<Integer> result = new ArrayList<>();
		PriorityQueue<HeapElement> minHeap = new PriorityQueue<>(new HeapComparator());

		// Add the first elements of all arrays to min heap
		for(int i = 0; i < kArrays.size(); i++)
		{
			HeapElement element = new HeapElement(kArrays.get(i).get(0), i, 0);
			minHeap.add(element);
		}

		while(minHeap.size() > 0)
		{
			HeapElement lowest = minHeap.poll();
			result.add(lowest.value);
			if(lowest.index < kArrays.get(lowest.list).size() - 1)
			{
				// Check if elements exists in that list after polled element
				HeapElement next = new HeapElement(kArrays.get(lowest.list).get(lowest.index + 1), lowest.list, lowest.index + 1);
				minHeap.add(next);
			}
		}

		return result;
	}
}
