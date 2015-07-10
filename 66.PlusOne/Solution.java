public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits.length == 0) return digits;
        int inc = 1;
        for(int i = digits.length - 1; i >= 0; i--) {
            int n = digits[i] + inc;
            inc = n / 10;
            digits[i] = n % 10; 
        }
        if(inc == 0) return digits;

        int[] n = new int[digits.length + 1];
        for(int i = digits.length; i >= 1; i--) {
            n[i] = digits[i - 1];
        }
        n[0] = 1; 
        return n; 
    }
}
