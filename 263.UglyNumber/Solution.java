public class Solution {
    public boolean isUgly(int num) {
        if(num == 0) return false;
        if(num == 1) return true;
        int[] primes = {2, 3, 5};
        for(int i = 0; i < primes.length; i++) {
            int tmpNum = num / primes[i];
            if(primes[i] * tmpNum == num && isUgly(tmpNum)) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int num = 14;
        System.out.println(sol.isUgly(num));
    }
}
