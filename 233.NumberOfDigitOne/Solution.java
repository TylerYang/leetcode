public class Solution {
    public int countDigitOne(int k) {
        int factor = 1, n = k, count = 0;
        while(n > 0) {
            int d = n % 10, m = n / 10, amount = 0;
            if(d == 0) {
                amount = 0;
            } else if(d > 1) {
                amount = factor;
            } else {
                amount = k % factor + 1;
            }
            count += m * factor + amount;
            factor *= 10;
            n /= 10;
        }
        return count;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 1432;
        System.out.println(sol.countDigitOne(n));
    }
}
