public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        if (s1.length() == 0) return s2.equals(s3);
        if (s2.length() == 0) return s1.equals(s3);

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = true;
                } else {
                    char currC = s3.charAt(i + j - 1);
                    if (i > 0 && dp[i - 1][j] == true) {
                        dp[i][j] = s1.charAt(i - 1) == currC;
                    } else if (j > 0 && dp[i][j - 1] == true) {
                        dp[i][j] = s2.charAt(j - 1) == currC;
                    }
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
