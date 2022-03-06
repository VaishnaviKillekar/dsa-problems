// Link to problem - https://leetcode.com/problems/champagne-tower/

/**
 * Initialize a matrix[101][101] to store the champagne in each glass.
 * Start with setting the total champagne poured in the first slot of matrix.
 * Now start checking if each glass in a row has champagne >= 1.
 * Since a glass can only hold 1, anything in excess will spill over to the
 * next row's glasses.
 * Each glass [i][j] spills its excess champagne to glasses in next row [i+1][j] & [i+1][j+1].
 *
 * If there is no spillover for an entire row, then all glasses so far have been either fully or
 * partially filled. In this case, we can stop iterating as there will be no change in subsequent glasses.
 *
 * Time complexity - O(n^2)
 * Space complexity - O(1)
 */
class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] tower = new double[101][101];
        tower[0][0] = poured;

        for(int i = 0; i < 100; i++) {
            boolean spilled = false;
            for(int j = 0; j <= i; j++) {
                if(tower[i][j] >= 1) {
                    spilled = true;
                    double excess = tower[i][j] - 1;
                    tower[i+1][j] += (excess / 2.0);
                    tower[i+1][j+1] += (excess / 2.0);
                    tower[i][j] = 1;
                }                
            }
            // If there was no spill for an entire row, then break out of loop
            if(!spilled) {
                break;
            }
        }

        return tower[query_row][query_glass];
    }
}
