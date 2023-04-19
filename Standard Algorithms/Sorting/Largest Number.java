// Link to problem - https://leetcode.com/problems/largest-number/description/

/**
 * Intuition - Create an equivalent string array of numbers. Define a custom
 * comparator to sort the string array. The comparator must sort elements
 * such that on appending the first string with second, we must get the highest
 * possible number.
 * sort() takes O(nlogn) time and comparator takes constant time.
 *
 * Time complexity - O(nlogn)
 * Space complexity - O(n)
 */
class Solution {
    public String largestNumber(int[] nums) {
      String[] strs = new String[nums.length];
      String largestNum = "";

      // Create a string array of given number array
      for(int i = 0; i < nums.length; i++) {
        strs[i] = String.valueOf(nums[i]);
      }

      // Override string comparator's compare() to return the given numbers in an order
      // such that the highest possible number can be created by sorting them
      Comparator<String> comparator = new Comparator<>() {
        @Override
        public int compare(String n1, String n2) {
          String n12 = n1 + n2;
          String n21 = n2 + n1;
          return n21.compareTo(n12);
        }
      };

      // Sort the string array using overrriden comparator
      Arrays.sort(strs, comparator);

      // Check if all numbers are zero
      if(strs[0].equals("0")) {
        return "0";
      }

      // Append all number strings in the sorted array to form largest number
      for(String s : strs) {
        largestNum += s;
      }

      return largestNum;
    }
}
