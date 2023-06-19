// Link to problem - https://leetcode.com/problems/subsets/

/**
 * Intuition - Intuitive Backtracking
 * Maintain a loop which goes through all elements and addds them in the result as single
 * element subsets. From this loop, we call recursive function which then adds rest of the
 * array elements to the right of the element. Index 'i' is used to track the current
 * element. The last added subset is fetched and elements from index i + 1 are added to it
 * in combinations using recursion.
 *
 * For ex: [1,2,3], result = []
 *                       [1, 2, 3]               result = [[]]
 *                     /     |     \
 *                  [1]     [2]     [3]         for loop in subsets() add these individual elements as subsets
 *                 /   \       \
 *            [1, 2]  [1, 3]    [2, 3]          getSubsets() for loop adds rest of the subsets
 *              |
 *          [1, 2, 3]
 * Time complexity - O(2^n)
 * Space complexity - O(n)
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> sets = new ArrayList<>();
        
        sets.add(new ArrayList<Integer>());
        
        for(int i = 0; i < nums.length; i++) {
            // Add the element itself
            sets.add(Arrays.asList(nums[i]));

            // Get subsets using current element
            getSubsets(nums, sets, i);
        }
        return sets;
    }

    public void getSubsets(int[] nums, List<List<Integer>> sets, int i) {
        // Get last added subset
        List<Integer> latest = sets.get(sets.size() - 1);

        // Add all combinations
        for(int j = i + 1; j < nums.length; j++) {
            List<Integer> next = new ArrayList<>();
            next.addAll(latest);
            next.add(nums[j]);
            sets.add(next);
            getSubsets(nums, sets, j);
        }
    }
}


/**
 * Intuition - Backtracking [ Concise solution ]
 * Use index to track the current element to be added. Since subsets are unique, only add elements
 * to 'curr' whose index is higher than current index to avoid permutations of already added subsets.
 *
 * Time complexity - O(2^n) - since total count of all subsets is 2^n 
 * Space complexity - O(n) - recursion tree at the max will have n levels. 'curr' at the max will hold all n elements.
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        generateSubsets(nums, res, new ArrayList<>(), 0);
        return res;
    }

    public void generateSubsets(int[] nums, List<List<Integer>> res, List<Integer> curr, int index) {
        res.add(new ArrayList<>(curr));

        for(int i = index; i < nums.length; i++) {
            curr.add(nums[i]);
            generateSubsets(nums, res, curr, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}


/** 
 * Intuition - Start with an empty array and use recursion to generate all subsets
 *             [ ]
 *       [1]   [2]    [3]
 *    [1,2]   [2,3]   [3,4]
 *   [1,2,3]
 * 
 * Time complexity - O(n)
 * Space complexity - O(logn)
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> sets = new ArrayList<>();
        sets.add(new ArrayList());
        powerSet(nums, sets, 0, sets.get(0));
        return sets;
    }
    
    public void powerSet(int[] nums, List<List<Integer>> sets, int pos, List<Integer> prev) {
        while(pos < nums.length) {
            List<Integer> curr = new ArrayList(prev);
            curr.add(nums[pos]);
            sets.add(curr);
            powerSet(nums, sets, pos+1, curr);
            pos++;
        }
    }
}
