// Link to problem - https://leetcode.com/problems/flood-fill/

/**
 * Intuition - DFS
 * Start with adding the given pixel to be coloured in the queue 'pixels'.
 * Colour the first pixel and check if the top, bottom, left and right
 * pixels are of the same colour.
 * If it's a match, then add that pixel to the queue and colour it.
 *
 * Continue colouring pixels until there are pixels in the queue.
 *
 * Time complexity - O(m*n)
 * Space complexity - O(m*n)
 */
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        List<List<Integer>> pixels = new ArrayList<>();
        pixels.add(Arrays.asList(sr, sc));
        
        int i = 0;
        int old = image[sr][sc];
        image[sr][sc] = color;
        while(i < pixels.size()) {
            List<Integer> curr = pixels.get(i);
            int row = curr.get(0);
            int col = curr.get(1);
            // Fill top
            if(row - 1 >= 0 && image[row-1][col] == old && old != color) {
                image[row-1][col] = color;
                pixels.add(Arrays.asList(row-1, col));
            }
            // Fill bottom
            if(row + 1 < image.length && image[row+1][col] == old && old != color) {
                image[row+1][col] = color;
                pixels.add(Arrays.asList(row+1, col));
            }
            // Fill left
            if(col - 1 >= 0 && image[row][col-1] == old && old != color) {
                image[row][col-1] = color;
                pixels.add(Arrays.asList(row, col-1));
            }
            // Fill right
            if(col + 1 < image[0].length && image[row][col+1] == old && old != color) {
                image[row][col+1] = color;
                pixels.add(Arrays.asList(row, col+1));
            }
            i++;
        }
        return image;
    }
}
