public class Solution2 {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] dp = new int[s.length() + 1];
        int cVal = (int) s.charAt(0) - (int) '0';
        if (cVal == 0) return 0;
        dp[0] = 1;
        dp[1] = 1;
        int[] off = {-1, 0};
        for (int i = 1; i < s.length(); i++) {
            int count = 0;
            for (int j = 0; j < off.length; j++) {
                int start = i + off[j];
                if (start >= 0 && s.charAt(start) != '0') {
                    int val = Integer.parseInt(s.substring(start, i + 1));
                    if (val >= 1 && val <= 26) {
                        dp[i + 1] += dp[start];
                    }
                }
            }
        }
        return dp[s.length()];
    }
}
