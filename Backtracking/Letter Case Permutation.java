// Link to problem - https://leetcode.com/problems/letter-case-permutation/

/**  
            a1b2              i=0, when it's at a, since it's a letter, we have two branches: a, A
         /        \
       a1b2       A1b2        i=1, when it's at 1, we only have 1 branch which is itself
        |          |   
       a1b2       A1b2        i=2, when it's at b, we have two branches: b, B
       /  \        / \
      a1b2 a1B2  A1b2 A1B2    i=3,  when it's at 2, we only have one branch.
       |    |     |     |
      a1b2 a1B2  A1b2  A1B2   i=4, = S.length(). End recursion, add permutation to ans. 
      
      During this process, we are changing the S char array itself
    */
class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        permute(res, 0, s.toCharArray());
        return res;
    }
    
    public void permute(List<String> res, int i, char[] arr) {
        if(i == arr.length) {
            res.add(new String(arr));
        }
        else {
            if(Character.isDigit(arr[i])) {
                permute(res, i+1, arr);
            }
            else {
                arr[i] = Character.toUpperCase(arr[i]);
                permute(res, i+1, arr);
                arr[i] = Character.toLowerCase(arr[i]);
                permute(res, i+1, arr);
            }
        }
    }
}
