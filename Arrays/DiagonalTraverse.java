// Link to problem - https://leetcode.com/problems/diagonal-traverse/

class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        char direction = 'U';    // U = up | D - down
        int i = 0;
        int j = 0;
        int k = 0;
        int order[] = new int[mat.length * mat[0].length];

        while(i < mat.length && j < mat[0].length) {
            order[k++] = mat[i][j];
            
            if(direction == 'U') {
                if(i-1 > -1 && j + 1 < mat[0].length) {
                    i--;
                    j++;
                }
                else {
                    // Check if we can move to the right
                    if(j + 1 < mat[0].length) {
                        j++;
                    }
                    // Else, move down
                    else {
                        i++;
                    }
                    // Change direction
                    direction = 'D';
                }
            }
            else {
                if(i + 1 < mat.length && j - 1 > -1) {
                    i++;
                    j--;
                }
                else {
                    // Check if we can move down
                    if(i + 1 < mat.length) {
                        i++;
                    }
                    // Else, move right
                    else {
                        j++;
                    }
                    // Change direction
                    direction = 'U';
                }
            }
        }
        return order;
    }
}