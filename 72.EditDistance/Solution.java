public class Solution {
    public int minDistance(String word1, String word2) {
        if(word1.length() == 0) return word2.length();
        if(word2.length() == 0) return word1.length();
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for(int i = 0; i < dp.length; i++) dp[i][0] = i;
        for(int i = 0; i < dp[0].length; i++) dp[0][i] = i;
        
        for(int i = 0; i < word1.length(); i++) {
            char c1 = word1.charAt(i);
            for(int j = 0; j < word2.length(); j++) {
                char c2 = word2.charAt(j);
                if(c1 == c2) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    int delete = dp[i][j + 1];
                    int replace = dp[i][j];
                    int insert = dp[i + 1][j];
                    dp[i + 1][j + 1] = min(delete, replace, insert) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
    private int min(int a, int b, int c) {
        int r = a < b ? a : b;
        return r < c ? r : c;
    }
}