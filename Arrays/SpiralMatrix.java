// Link to problem - https://leetcode.com/problems/spiral-matrix/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList();
        int left = -1;
        int right = matrix[0].length;
        int top = -1;
        int bottom = matrix.length;
        int i = 0, j = 0;
        
        while(i > top && i < bottom && j > left && j < right) {
            if(!(j > left && j < right)) {
                continue;
            }
            while(j > left && j < right) {
                order.add(matrix[i][j]);
                j++;
            }
            j--;
            i++;
            top++;
            if(!(i > top && i < bottom)) {
                continue;
            }
            while(i > top && i < bottom) {
                order.add(matrix[i][j]);
                i++;
            }
            i--;
            j--;
            right--;
            if(!(j > left && j < right)) {
                continue;
            }
            while(j > left && j < right) {
                order.add(matrix[i][j]);
                j--;
            }
            j++;
            i--;
            bottom--;
            
            while(i > top && i < bottom) {
                order.add(matrix[i][j]);
                i--;
            }
            left++;
            i++;
            j++;
        }
        return order;
    }
}