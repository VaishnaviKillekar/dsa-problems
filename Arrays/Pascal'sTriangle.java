// Link to problem - https://leetcode.com/problems/pascals-triangle/

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();        
        
        List<Integer> subList = new ArrayList<>();
        subList.add(1);
        result.add(subList);
        
        for(int n = 1; n < numRows; n++) {
            subList = new ArrayList<>();
            subList.add(1);
            for(int r = 1; r < n; r++) {
                subList.add(result.get(n-1).get(r-1) + result.get(n-1).get(r));
            }
            subList.add(1);
            result.add(subList);
        }
        
        return result;
    }
}