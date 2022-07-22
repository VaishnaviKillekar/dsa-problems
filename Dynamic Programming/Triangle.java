// Link to problem - https://leetcode.com/problems/triangle/

/**
 * Intuition - Bottom Up approach
 * The minimum path sum is obtained by choosing an element at each level.
 * Only the consecutive elements in the next level can be chosen for each element.
 * There can be elements which might be greater than others in the same level, but 
 * their path might yield the shortest path. Hence, this can be solved with Greedy
 * approach. The shortest path depends on carefully choosing elements at each level
 * to minimise the overall result.
 * This indicates this is DP problem as the future result depends on current and older
 * choices and the subproblems are overlapping.
 *
 * Recurrence relation - 
 * Left extreme element - Sum of current element and previous level's left extreme element
 * Right extreme element - Sum of current element and previous level's right extreme element
 * Middle elements - Minimum of (Sum of current element and the previous level's left (i) and right (i+1) elements).
 *
 * Time complexity - O(m*n)
 * Space complexity - O(m*n)
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int result = Integer.MAX_VALUE;
        List<List<Integer>> path = new ArrayList<>();
        path.add(triangle.get(0));
        
        if(triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        
        for(int i = 1; i < triangle.size(); i++) {
            List<Integer> level = new ArrayList<>();
            for(int j = 0; j < triangle.get(i).size(); j++) {
                int dist;
                // First element can only be reached from first element of previous step
                if(j == 0) {
                    dist = path.get(i - 1).get(j) + triangle.get(i).get(j);
                }
                // Last element can only be reached from last element of previous step
                else if(j == triangle.get(i).size() - 1) {
                    dist = path.get(i - 1).get(j - 1) + triangle.get(i).get(j);
                }
                // Middle elements can be reached from their left and right neighbors of previous step
                else {
                    dist = Math.min(path.get(i - 1).get(j - 1), path.get(i - 1).get(j)) + triangle.get(i).get(j);
                }
                if(i == triangle.size() - 1 && result > dist) {
                    result = dist;
                }
                level.add(dist);
            }
            path.add(level);
        }
        
        return result;
    }
}

/**
 * Efficient solution with space complexity - O(n)
 * where, n is number of rows in triangle
 *
 * Start with the bottom of the triangle. Find the minimum between adjacent elements
 * of auxiliary array A whose size is n + 1 and add the current element value of traingle
 * to it.
 * Do this until the top row is iterated through. The result will be available in the
 * first position of auxiliary array A.
 *
 * Time complexity - O(m*n)
 * Space complexity - O(n)
 */
public int minimumTotal(List<List<Integer>> triangle) {
    int[] A = new int[triangle.size() + 1];
    for(int i = triangle.size() - 1; i >= 0; i--){
        for(int j = 0; j < triangle.get(i).size(); j++){
            A[j] = Math.min(A[j], A[j+1]) + triangle.get(i).get(j);
        }
    }
    return A[0];
}
