public class Solution {
    public int numDistinct(String s, String t) {
        if(s.length() == 0) return t.length() == 0 ? 1 : 0;
        if(s.length() == 1 && t.length() == 1) return s.charAt(0) == t.charAt(0) ? 1 : 0;
        
        int[] dp = new int[s.length()];
        int prevDP = 1;
        for(int i = 1; i <= s.length(); i++) {
            dp[i] = 1;
        }

        for(int i = 1; i <= t.length(); i++) {
            for(int j = 1; j <= s.length(); j++) {
                int tmp = dp[j];
                dp[j] = dp[j - 1] + (s.charAt(j - 1) == t.charAt(i - 1) ? prevDP : 0);
                prevDP = tmp;
            }
            prevDP = 0;
        }
        return dp[s.length()];
    }
}
