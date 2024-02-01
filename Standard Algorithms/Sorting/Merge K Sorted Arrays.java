// Link to problem - https://www.codingninjas.com/studio/problems/merge-k-sorted-arrays_975379

/**
 * Intuition - Since the k arrays are already sorted, we can use merge sort to merge these array
 * two at a time until all arrays are merged into one single array.
 *
 * Time complexity - O(klogn)
 * Space complexity - O(k)
 */
public class Solution 
{
	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
	{
		return mergeSort(kArrays, 0, kArrays.size() - 1);
	}

	public static ArrayList<Integer> mergeSort(ArrayList<ArrayList<Integer>> kArrays, int start, int end)
	{
		if(start > end) {
			return new ArrayList<Integer>();
		}
		else if(start == end)
		{
			return kArrays.get(start);
		}
		else
		{
			int mid = (start + end) / 2;
			ArrayList<Integer> first = mergeSort(kArrays, start, mid);
			ArrayList<Integer> second = mergeSort(kArrays, mid + 1, end);
			return merge(first, second);
		}
	}

	public static ArrayList<Integer> merge(ArrayList<Integer> first, ArrayList<Integer> second)
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		int i = 0;
		int j = 0;

		while(i < first.size() && j < second.size())
		{
			if(first.get(i) < second.get(j))
			{
				result.add(first.get(i));
				i++;
			}
			else
			{
				result.add(second.get(j));
				j++;
			}
		}
		while(i < first.size())
		{
			result.add(first.get(i));
			i++;
		}
		while(j < second.size())
		{
			result.add(second.get(j));
			j++;
		}

		return result;
	}
}
