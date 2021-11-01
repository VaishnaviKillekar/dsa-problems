// Link to problem - https://leetcode.com/problems/plus-one/

class Solution {
    public int[] plusOne(int[] digits) {
        LinkedList<Integer> sum = new LinkedList();
        Integer carry = 1;
        
        for(int i = digits.length - 1; i > -1; i--) {
            sum.addFirst((digits[i] + carry) % 10);
            carry = (digits[i] + carry) / 10;
        }
        if(carry > 0) {
            sum.addFirst(carry);
        }
        return sum.stream().mapToInt(i -> i).toArray();
    }
}


// Optimized solution
class Solution {
    public int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; i > -1; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            else {
                digits[i] = 0;
            }
        }
        if(digits[0] == 0){
            int[] sum = new int[digits.length+1];
            sum[0] = 1;
            return sum;
        }
        return digits;
    }
}