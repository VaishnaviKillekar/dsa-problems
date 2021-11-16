// Link to problem - https://leetcode.com/problems/set-matrix-zeroes/

class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> cols = new TreeSet();

        for(int i = 0; i < matrix.length; i++) {
            boolean flag = false;
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    flag = true;
                    cols.add(j);
                }
            }
            if(flag) {
                matrix[i] = new int[matrix[0].length];
            }
        }

        for(int j : cols) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][j] = 0;
            }
            j++;            
        }
    }
}