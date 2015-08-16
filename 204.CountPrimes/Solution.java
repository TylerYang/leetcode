import java.util.*;
public class Solution {
    public int countPrimes(int n) {
        if(n <= 2) return 0;
		boolean[] isNotPrime = new boolean[n];
        int i = 2;
        int end = (int) Math.sqrt(n);
        while(i <= end) {
            for(int j = i + i; j < n && j > 0; j += i) {
				isNotPrime[j] = true;
            }
            i++;
        }
    
        int count = 0;
        for(i = 2; i < n; i++) {
            if(isNotPrime[i] == false) {
				count++;
			}
        }
        return count;
    }
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.countPrimes(999983));
	}
}