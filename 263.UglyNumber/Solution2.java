public class Solution2 {
    public boolean isUgly(int num) {
        if(num <= 0) return false;
        int[] primes = {2, 3, 5};
        for(int i = 0; i < primes.length; i++) {
            while(num % primes[i] == 0) {
                num /= primes[i];
            }
        }
        return num == 1;
    }
    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        int num = 12;
        System.out.println(sol.isUgly(num));
    }
}
