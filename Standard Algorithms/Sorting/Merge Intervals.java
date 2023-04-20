// Link to problem - https://leetcode.com/problems/merge-intervals/description/

/**
 * Intuition -  Sort the intervals array in ascending order of start of intervals.
 * Iterate through the sorted intervals and merge the intervals when they overlap.
 * Consider the edge case with last element, where it could either have been merged
 * with previous intervals or does not overlap, add that last interval to result.
 *
 * Time complexity - O(nlogn)
 * Space complexity - O(n)
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> result = new ArrayList<>();

        // Customize comparator to sort the intervals based on start of the intervals
        Comparator<int[]> comparator = new Comparator<>() {
            @Override
            public int compare(int[] in1, int[] in2) {
                return Integer.compare(in1[0], in2[0]);
            }
        };
        Arrays.sort(intervals, comparator);

        // Merge the overlapping intervals
        int[] curr = intervals[0];
        boolean merge = true;
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] >= curr[0] && intervals[i][0] <= curr[1]) {
                // Merge the overlapping intervals
                curr[1] = Math.max(curr[1], intervals[i][1]); 
                merge = true;
            }
            else {
                // No overlap - add curr to result and use the 'i'th interval as curr
                List<Integer> list = new ArrayList<>();
                list.add(curr[0]);
                list.add(curr[1]);
                result.add(list);
                curr = intervals[i];
                merge = false;
            }
        }

        if(merge) {
            // Add curr to result
            List<Integer> list = new ArrayList<>();
            list.add(curr[0]);
            list.add(curr[1]);
            result.add(list);
        }
        else {
            List<Integer> list = new ArrayList<>();
            list.add(intervals[intervals.length - 1][0]);
            list.add(intervals[intervals.length - 1][1]);
            result.add(list);
        }

        int[][] merged = new int[result.size()][2];
        for(int i = 0; i < result.size(); i++) {
            merged[i][0] = result.get(i).get(0);
            merged[i][1] = result.get(i).get(1);
        }
        return merged;
    }
}
