public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        for(int i = 1; i <= s.length(); i++) {
            if(wordDict.contains(s.substring(0, i)) == true) {
                dp[i - 1] = true;
            } else {
                for(int j = 0; j < i; j++) {
                    if(dp[j] == true) {
                        if(wordDict.contains(s.substring(j + 1, i))) {
                            dp[i - 1] = true;
                            break;
                        }
                    }
                }
            }
            
        }
        return dp[s.length() - 1];
    }
}