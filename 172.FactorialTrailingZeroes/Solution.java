public class Solution {
    public int trailingZeroes(int n) {
        if(n < 0) return -1;
        int count = 0;
        while(n > 0) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }
}